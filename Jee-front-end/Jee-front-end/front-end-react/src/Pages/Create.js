import React, { useState } from "react";
import { Button, Form } from "semantic-ui-react";
import { useNavigate } from "react-router-dom";
const create = () => {
    const navigate = useNavigate()
  const [inputValues, setInputValues] = useState({
    id: "",
    name :"",
  });
  const handleOnChange = (event) => {
    const { name, value } = event.target;
    setInputValues({ ...inputValues, [name]: value });
  };
  const onSubmitHandler = (e) => {
    e.preventDefault();
    console.log(inputValues)
    fetch('http://localhost:8080/client/create',{
        method:'POST',
        headers:{
            'Content-Type': 'application/json'
        },
        body:JSON.stringify(inputValues)
    }).then(raw => raw.json()).then(data => {
        navigate('/AllFactures')
    })
  };

  return (
    <Form onSubmit={onSubmitHandler}>
      <Form.Field>
        <label>ID</label>
        <input placeholder="ID" name="id" onChange={handleOnChange} />
      </Form.Field>
      <Form.Field>
        <label>name</label>
        <input
            value={inputValues.name}
          placeholder="name"
          name="name"
          onChange={handleOnChange}
        />
      </Form.Field>
      <Button color="green">Create</Button>
    </Form>
  );
};

export default create;

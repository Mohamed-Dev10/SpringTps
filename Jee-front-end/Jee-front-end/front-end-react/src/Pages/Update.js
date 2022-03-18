import React, { useEffect, useState } from "react";
import { Button, Form } from "semantic-ui-react";
import { useNavigate, useParams } from "react-router-dom";


  
  const UpdateFacture = () => {
    const navigate = useNavigate();
    const [inputValues, setInputValues] = useState({
      id: "",
      name: "",
    });
    const handleOnChange = (event) => {
      const { name, value } = event.target;
      setInputValues({ ...inputValues, [name]: value });
    };
    const onSubmitHandler = (e) => {
      e.preventDefault();
      console.log(inputValues);
      fetch("http://localhost:8080/client/modify", {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(inputValues),
      })
        .then((raw) => raw.json())
        .then((data) => {
          navigate("/AllFactures");
        });
    };
    const params = useParams()
    useEffect(() => {
        fetch('http://localhost:8080/client/'+params.id , {
        }).then(raw => raw.json()).then(data => {
        setInputValues(data)
        console.log(data)
        })
    },[])
  return (
    <Form onSubmit={onSubmitHandler}>
      <Form.Field>
        <label>ID</label>
        <input placeholder="ID" name="id" onChange={handleOnChange} defaultValue={inputValues.id} />
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
      <Button color="yellow">Update</Button>
    </Form>
  );
};

export default UpdateFacture;

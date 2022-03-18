import React, { useState } from "react";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import AllFactures from "./Pages/AllFactures";
import { Menu } from "semantic-ui-react";
import Create from "./Pages/create";
import UpdateFacture from "./Pages/Update";
const App = () => {

  const [activeItem, setActiveItem] = useState();
  const handleItemClick = (e, { name }) => setActiveItem(name);

  return (
    <BrowserRouter>
      <Menu>
        <Link to={"/AllFactures"}>
          <Menu.Item
          as={'div'}

            name="AllFactures"
            active={activeItem === "AllFactures"}
            onClick={handleItemClick}
          >
            View All client
          </Menu.Item>
        </Link>

        <Link to={"/create"}>
          <Menu.Item
          as={'div'}
            name="create"
            active={activeItem === "create"}
            onClick={handleItemClick}
          >
            Create New client
          </Menu.Item>
        </Link>

      </Menu>
      <Routes>
        <Route path="/AllFactures" element={<AllFactures />}></Route>
        <Route path="/Create" element={<Create />}></Route>
        <Route path="/Update/:id" element={<UpdateFacture />}></Route>
      </Routes>
    </BrowserRouter>
  );
};

export default App;

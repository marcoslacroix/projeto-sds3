import NavBar from 'components/NavBar';
import Footer from 'components/Footer';
import DataTable from 'components/DataTable';
import React from 'react';

function App() {
  return (
    <>
    <div className="container">
        <NavBar />
        <h1 className="text-primary">Olá Mundo</h1>
        <DataTable/>
    </div>
    <Footer/>
    </>
  );
}

export default App;

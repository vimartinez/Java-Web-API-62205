import React, {useState} from "react";
import 'bootstrap/dist/css/bootstrap.css'

const emailRegexp = new RegExp(/[^@ \t\r\n]+@[^@ \t\r\n]+\.[^@ \t\r\n]+/);
const Formulario = () => {
    
    const [datos, setDatos] = useState({
        nombre:'',
        apellido:'',
        mail:''
    })

    const [showMessage, setShowMessage] = useState(false)
    const updShowMessage = (estado) => {
        setShowMessage(estado);
    }

    const handleInputChange = (event) => {
      //  console.log(event.target.name);
      //  console.log(event.target.value);
        setDatos({
            ...datos,
            [event.target.name] : event.target.value
        })
    }

    const handleBlur = () => {
        if (emailRegexp.test(datos.mail)){
            console.log("email verificado!");
            updShowMessage(false);
        } else {
            console.log("No es una dirección de mail válida");
            updShowMessage(true);
        }
    }

    const enviarDatos = (event) => {
        event.preventDefault();
        console.log('enviando:' + datos.nombre + ' ' + datos.apellido + ' ' + datos.mail);
        //validaciones
        // envío a backend
    }

    return(
        <div clasName='mt-5'>
            <h4> Registrate en el sistema!</h4>
            <form onSubmit={enviarDatos}>
                <div className="row m-1">
                    <div className="col-md-3">
                        <input 
                            className="form-control"
                            type="text" 
                            placeholder="Nombre" 
                            name="nombre"
                            onChange={handleInputChange}>
                        </input>
                    </div>
                    <div className="col-md-3">
                        <input 
                            className="form-control"
                            type="text" 
                            placeholder="Apellido" 
                            name="apellido"
                            onChange={handleInputChange}>
                        </input>
                    </div>
                </div>
                <div className="row m-1">
                    <div className="col-md-6">
                        <input
                            className="form-control"
                            type="mail"
                            placeholder="Mail"
                            onChange={handleInputChange}
                            onBlur={handleBlur}
                            name="mail"
                        ></input>
                    </div>
                </div>
                <div className="row m-1">
                    <div className="col-md-3">
                        <button type="submit" className="btn btn-primary">Registrase</button>
                    </div>
                </div>
            </form>
            <div className="alert alert-danger" role="alert" style={{visibility: showMessage ? "visible" : "hidden" }}>
                Tenés que ingresar un mail válido!
            </div>
        </div>
    )
}

export default Formulario;
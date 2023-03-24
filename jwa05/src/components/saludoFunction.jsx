import React, {useState} from "react";
import PropTypas from 'prop-types';

const SaludoFunction = (props) => {

    const [age, setAge] = useState(35)
    const incrementAge = () => {
        setAge(age +1)
    }

    return(
        <div>
            <h3> Componente Function</h3>
            <h4>Hola: {props.name}</h4>
            <h4>Tu edad es: {age}</h4>
            <div>
                <button onClick={incrementAge}>Cumplir Años</button>
            </div>
        </div>
    )
}

SaludoFunction.propTypes = {
    name: PropTypas.string

}

export default SaludoFunction;
import React, {useState} from "react";
import 'bootstrap/dist/css/bootstrap.css'

const SaludoBootstrap = (props) => {
    return(
        <div>
            <div class="alert alert-warning" role="alert"> Este es un texto con estilo de Bootstrap</div>
            <div class="alert alert-dark" role="alert"> Este es un texto con estilo de Bootstrap</div>
        </div>
    )
}

export default SaludoBootstrap;
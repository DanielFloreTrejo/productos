<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario Simple</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 50px;
        }
        label {
            display: block;
            margin-top: 10px;
        }
        input {
            margin-bottom: 10px;
            padding: 5px;
            width: 300px;
        }
        button {
            padding: 8px 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Formulario de Ejemplo</h1>
    <form>
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre">
        
        <label for="apellido">Apellido:</label>
        <input type="text" id="apellido" name="apellido">
        
        <button type="submit">Enviar</button>
    </form>
</body>
</html>
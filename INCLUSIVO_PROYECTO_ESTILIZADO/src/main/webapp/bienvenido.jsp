<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio</title>
    <link rel="stylesheet" href="css/bienvenido.css"> 
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
    <div class="sidebar">
        <div class="menu-icon">
            <i class="fas fa-bars"></i>
        </div>
        <div class="dropdown-menu">
            <a href="#">Perfil</a>
            <a href="#">Configuracion</a>
            <a href="#">Ayuda</a>
            <a href="#">Cerrar Sesion</a>
        </div>
    </div>

    <div class="main-content">
        <div class="header">
            <h1>Bienvenido/a <span id="user-at">${not empty sessionScope.nombre ? '@' : ''}${sessionScope.nombre}</span></h1>
        </div>
        <div class="progress-container">
            <div class="progress-box">Progreso del Curso 1</div>
            <div class="progress-box">Progreso del Curso 2</div>
        </div>
        <button class="add-course-button">+</button>
    </div>

    <script>
        document.addEventListener('DOMContentLoaded', function() {
            const menuIcon = document.querySelector('.menu-icon');
            const sidebar = document.querySelector('.sidebar');

            menuIcon.addEventListener('click', function() {
                sidebar.classList.toggle('active');
            });

        });
    </script>
</body>
</html>
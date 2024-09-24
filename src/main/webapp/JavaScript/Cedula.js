/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


$(document).ready(function() {
    function actualizarMarcadorLocal() {
        var golesLocal = 0;
        $('.golesLocal').each(function() {
            golesLocal += parseInt($(this).val() || 0);
        });
        $('#marcadorLocal').val(golesLocal);
    }

    function actualizarMarcadorVisitante() {
        var golesVisitante = 0;
        $('.golesVisitante').each(function() {
            golesVisitante += parseInt($(this).val() || 0);
        });
        $('#marcadorVisitante').val(golesVisitante);
    }

    // Actualizar los marcadores cuando cambia el valor de los goles locales
    $('.golesLocal').change(function() {
        actualizarMarcadorLocal();
    });

    // Actualizar los marcadores cuando cambia el valor de los goles visitantes
    $('.golesVisitante').change(function() {
        actualizarMarcadorVisitante();
    }); 
    // Ajustar valor del checkbox
     $('input[type="checkbox"]').change(function() {
            if ($(this).is(':checked')) {
                $(this).val('1');
            } else {
                $(this).val('0');
            }
        });

                 // Ajustar valor del checkbox
        $('input[type="checkbox"]').change(function() {
            var isChecked = $(this).prop('checked');
            var row = $(this).closest('tr'); // Obtener la fila más cercana al checkbox
            var inputs = row.find('input[type="number"]'); // Obtener todos los inputs de la fila
            if (!isChecked) {
                // Si la casilla está desmarcada, cambiar el color de fondo a rojo y deshabilitar los inputs
                row.css('background-color', 'red');
                inputs.prop('disabled', true);
            } else {
                // Si la casilla está marcada, restaurar el color de fondo y habilitar los inputs
                row.css('background-color', '');
                inputs.prop('disabled', false);
            }
        });
                // Manejar el cambio en los inputs de tarjetas amarillas
        $('input[name^="amarillas_"]').change(function() {
            var valorAmarillas = parseInt($(this).val());
            if (valorAmarillas === 2) {
                // Cambiar automáticamente a tarjeta roja cuando se recibe una segunda amarilla
                var row = $(this).closest('tr'); // Obtener la fila más cercana al input
                var tarjetaRojaInput = row.find('input[name^="rojas_"]');
                tarjetaRojaInput.val(1); // Cambiar automáticamente a tarjeta roja
            }
        });
});
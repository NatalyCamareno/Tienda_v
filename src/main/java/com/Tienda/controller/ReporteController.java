
package com.Tienda.controller;


import com.Tienda.Tienda.service.ReporteService;
import jakarta.mail.internet.ParseException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


//Sobre la convención de nombres, llegaba el punto donde se tenia que empezar de 0 y aunque se borrara de raiz el archivo, no dejaba volver a usar el mismo nombre, de igual forma está adaptado como corresponde. 
@Controller
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/principal")
    public String listado(Model model) {
        Calendar fecha = Calendar.getInstance();
        String FechaInicial = "" + (fecha.get(Calendar.YEAR) - 1) + "-01-01";

        String strMes = (fecha.get(Calendar.MONTH) < 10 ? "0" : "") + fecha.get(Calendar.MONTH);

        String strDia = (fecha.get(Calendar.DAY_OF_MONTH) < 10 ? "0" : "") + fecha.get(Calendar.DAY_OF_MONTH);

        String FechaFinal = "" + fecha.get(Calendar.YEAR) + "-" + strMes + "-" + strDia;

        model.addAttribute("FechaInicial", FechaInicial);
        model.addAttribute("FechaFinal", FechaFinal);

        return "/reportes/principal";
    }

    @GetMapping("/Usuarios")
    public ResponseEntity<Resource> reporteUsuarios(@RequestParam String tipo)
            throws IOException {
        return reporteService.generaResporte("Usuarios", null, tipo);
    }

    @GetMapping("/Ventas")
    public ResponseEntity<Resource> reporteVentas(@RequestParam String tipo)
            throws IOException {
        return reporteService.generaResporte("Ventas", null, tipo);
    }

    //Se hicieron ajustes (SimpleDataFormat) ya que de la forma base presentada en Lec12 no funcionaba de forma correcta VentaTotales pero MasVendidos si funcionaba bien pese a ser la misma estructura
    @GetMapping("/VentaTotales")
    public ResponseEntity<Resource> reporteVentaTotales(
            @RequestParam String FechaInicial,
            @RequestParam String FechaFinal,
            @RequestParam String tipo) throws IOException, ParseException, java.text.ParseException {

SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaIni = formato.parse(FechaInicial);
        Date fechaFin = formato.parse(FechaFinal);

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("FechaInicial", fechaIni);
        parametros.put("FechaFinal", fechaFin);

        return reporteService.generaResporte("VentaTotales", parametros, tipo);

    }

    @GetMapping("/StockActual")
    public ResponseEntity<Resource> reporteStockActual(@RequestParam String tipo) throws IOException {
        return reporteService.generaResporte("StockActual", null, tipo);
    }

    @GetMapping("/MasVendidos")
    public ResponseEntity<Resource> reporteMasVendidos(
            @RequestParam String FechaInicial,
            @RequestParam String FechaFinal,
            @RequestParam String tipo) throws IOException {

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("FechaInicial", FechaInicial);
        parametros.put("FechaFinal", FechaFinal);

        return reporteService.generaResporte("MasVendidos", parametros, tipo);
    }
}

package com.example.microservicioTecnico;

import com.example.microservicioTecnico.Model.ActivoModel;
import com.example.microservicioTecnico.Model.PuntoVentaModel;
import com.example.microservicioTecnico.Model.UsuarioModel;
import com.example.microservicioTecnico.Repository.ActivoRepository;
import com.example.microservicioTecnico.Repository.PuntoVentaRepository;
import com.example.microservicioTecnico.Repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;

@SpringBootApplication
public class MicroservicioTecnicoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioTecnicoApplication.class, args);
    }

    @Bean
    public CommandLineRunner sembrarDatosIniciales(
            UsuarioRepository usuarioRepo,
            PuntoVentaRepository puntoRepo,
            ActivoRepository activoRepo
    ) {
        return args -> {
            if (usuarioRepo.count() == 0) {
                String hashClaveDemo = sha256("Clave123");
                usuarioRepo.saveAll(List.of(
                        new UsuarioModel(null, "Tomás Rivera", "tecnico@demo.cl", hashClaveDemo, "OPERARIO", "Técnico de mantenimiento"),
                        new UsuarioModel(null, "Valentina Soto", "vendedor@demo.cl", hashClaveDemo, "OPERARIO", "Vendedora"),
                        new UsuarioModel(null, "Diego Muñoz", "transportista@demo.cl", hashClaveDemo, "OPERARIO", "Transportista"),
                        new UsuarioModel(null, "Carla Fuentes", "supervisor@demo.cl", hashClaveDemo, "SUPERVISOR", "Supervisora de operaciones")
                ));
            }
            if (puntoRepo.count() == 0) {
                List<PuntoVentaModel> puntos = puntoRepo.saveAll(List.of(
                        new PuntoVentaModel(null, "Minimarket El Alba", "Av. Ficticia 1234", "Cerrillos", -33.5160, -70.7170),
                        new PuntoVentaModel(null, "Almacén Los Aromos", "Pasaje Demo 456", "Maipú", -33.5105, -70.7580),
                        new PuntoVentaModel(null, "Minimarket Las Rosas", "Calle Ejemplo 789", "Santiago", -33.4489, -70.6693),
                        new PuntoVentaModel(null, "Botillería La Esquina", "Av. Prueba 321", "Estación Central", -33.4569, -70.6983)
                ));
                if (activoRepo.count() == 0 && puntos.size() >= 4) {
                    activoRepo.saveAll(List.of(
                            new ActivoModel(null, "TDV-VF-001", "VITRINA_FREEZER", "FrioMax", "VF-300", puntos.get(0).getId()),
                            new ActivoModel(null, "TDV-CS-001", "CONSERVADORA", "GlaciaPro", "CS-150", puntos.get(0).getId()),
                            new ActivoModel(null, "TDV-VF-002", "VITRINA_FREEZER", "FrioMax", "VF-450", puntos.get(1).getId()),
                            new ActivoModel(null, "TDV-CS-002", "CONSERVADORA", "GlaciaPro", "CS-200", puntos.get(2).getId()),
                            new ActivoModel(null, "TDV-VF-003", "VITRINA_FREEZER", "PolarLine", "PL-500", puntos.get(2).getId()),
                            new ActivoModel(null, "TDV-CS-003", "CONSERVADORA", "PolarLine", "PL-120", puntos.get(3).getId())
                    ));
                }
            }
        };
    }

    private static String sha256(String texto) throws Exception {
        byte[] digest = MessageDigest.getInstance("SHA-256").digest(texto.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}

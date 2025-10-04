package com.marcosviniciusdev.config;

import com.marcosviniciusdev.model.Usuario;
import com.marcosviniciusdev.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (usuarioRepository.findByEmail("admin@doevida.com").isEmpty()) {
            Usuario admin = new Usuario();
            admin.setNome("Administrador");
            admin.setCpf("00000000000");
            admin.setEmail("admin@doevida.com");
            admin.setSenhaHash(passwordEncoder.encode("admin123"));
            admin.setPerfil("ADMIN");
            admin.setAtivo(true);

            usuarioRepository.save(admin);

            System.out.println("✅ Usuário ADMIN inicial criado: admin@doevida.com / admin123");
        }
    }
}
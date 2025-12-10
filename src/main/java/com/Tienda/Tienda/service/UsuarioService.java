UsuarioService(UsuarioRepository usuarioRepository,
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    @Transactional(readOnly = true) //CRUD -> READ (LIST)
    public List<Usuario> getUsuarios(boolean activo) {
        if (activo) {
            return usuarioRepository.findByActivoTrue();
        }
        return usuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Transactional(readOnly = true) //ID del usuario
    public Optional<Usuario> getUsuario(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }
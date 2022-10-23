package backend.json.teste.sec;

public enum AppPerms {
    CRIA_DESTINO("destino:criar"),
    DELETA_DESTINO("destino:deleta"),
    GERAR_TICKETS("tickets:gerar"),
    COMPRAR_TICKETS("perfil:compraTicket"),
    ACHAR_PERFIL("perfil:umPerfil"),
    LISTAR_PERFIL("perfil:todosPerfil"),
    ATUALIZA_PERFIL("perfil:atualizar");


    private final String permission;

    AppPerms(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }


}

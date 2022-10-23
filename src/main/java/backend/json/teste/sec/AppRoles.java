package backend.json.teste.sec;

import  com.google.common.collect.Sets;

import java.util.Collections;
import  java.util.Set;

import static backend.json.teste.sec.AppPerms.*;

public enum AppRoles {
    ADMIN(Sets.newHashSet(ACHAR_PERFIL,ATUALIZA_PERFIL, CRIA_DESTINO, DELETA_DESTINO, GERAR_TICKETS,LISTAR_PERFIL)),
    AGENTE(Sets.newHashSet(CRIA_DESTINO, DELETA_DESTINO, GERAR_TICKETS)),
    PERFIL(Sets.newHashSet(COMPRAR_TICKETS, ATUALIZA_PERFIL, ACHAR_PERFIL));

    private final Set<AppPerms> permissions;

    AppRoles(Set<AppPerms> permissions) {
        this.permissions = permissions;
    }
}

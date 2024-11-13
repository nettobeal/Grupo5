package entidade;

public class PerfilRisco {
    private int id_Perfil;
    private String descricao;

    public PerfilRisco(String descricao, int id_Perfil) {
        this.descricao = descricao;
        this.id_Perfil = id_Perfil;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId_Perfil() {
        return id_Perfil;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId_Perfil(int id_Perfil) {
        this.id_Perfil = id_Perfil;
    }
}

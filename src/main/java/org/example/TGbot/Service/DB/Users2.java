package org.example.TGbot.Service.DB;

        import lombok.Data;

        import javax.persistence.*;
        import java.io.Serializable;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Table(name = "users2")
public class Users2 implements Serializable {

    private static final long serialVersionUID = 1L;

    public Users2 (){

    }
    public Users2(String name, Long chatid){
        this.username = name;
        this.record = 0L;
        this.chatid = chatid;


    }
    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "chatid", nullable = false)
    private Long chatid;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "record", nullable = false)
    private Long record;

    public void setRecord (Long record){
        this.record = record;
    }

}


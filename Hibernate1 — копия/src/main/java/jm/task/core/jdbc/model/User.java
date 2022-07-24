package jm.task.core.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Table(name = "usershii", schema = "my_db", catalog = "")


public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    //    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    //    @Basic
    @Column(name = "lastName", nullable = true, length = 45)
    private String lastName;

    //    @Basic
    @Column(name = "age", nullable = true)
    private int age;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " (id = " + id + ", name = " + name + ", lastName = " + lastName + ", age = " + age + ")";
    }
}
//package vn.iotstar.Entity;
//
//import javax.persistence.Column;
//
//import jakarta.persistence.Entity;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "Category")
//public class CategoryEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(columnDefinition = "nvarchar(255)")
//    private String categoryName;
//
//    @Column(columnDefinition = "nvarchar(255)")
//    private String categoryThumb;
//
//    @Column(columnDefinition = "nvarchar(MAX)")
//    private String categoryDescription;
//}


// CategoryEntity.java
package vn.iotstar.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "nvarchar(255)")
    private String categoryName;

    @Column(columnDefinition = "nvarchar(255)")
    private String categoryThumb;

    @Column(columnDefinition = "nvarchar(MAX)")
    private String categoryDescription;
}
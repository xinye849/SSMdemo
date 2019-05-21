/**
 * FileName: Student
 * Author:   Dragon
 * Date:     2019/5/20 11:15
 * History:
 */
package com.loyal.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class Student implements Serializable {
    private Integer id;
    private String name;
    private String subject;
    private Integer score;
}

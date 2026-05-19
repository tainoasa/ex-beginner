package com.example.ex_beginner.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserForm {
    @NotBlank(message = "名前は必須です。")
    private String name;
    @NotBlank(message = "年齢は必須です。")
    private String age;
    @NotBlank(message = "コメントは必須です。")
    private String comment;

    public int getIntVal(String num) {
        return Integer.parseInt(num);
    }
}

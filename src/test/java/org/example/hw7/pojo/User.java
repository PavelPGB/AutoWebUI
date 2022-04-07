package org.example.hw7.pojo;

/** AutoWebUI. HomeWork-7
 *
 * @author Pavel Pulyk
 * @version 0.1 07.04.2022
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String email;
    private String password;
}

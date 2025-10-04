//package vn.iotstar.Model;
//
//import lombok.Data;
//
//@Data
//public class LoginDto {
//	private String usernameOrEmamil;
//	private String password;
//}
package vn.iotstar.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private String usernameOrEmail;
    private String password;
}
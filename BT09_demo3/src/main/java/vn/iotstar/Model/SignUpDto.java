//package vn.iotstar.Model;
//
//import lombok.Data;
//
//@Data
//public class SignUpDto {
//	private String name;
//	private String username;
//	private String email;
//	private String password;
//	private boolean enabled;
//}


package vn.iotstar.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {
    private String name;
    private String username;
    private String email;
    private String password;
}
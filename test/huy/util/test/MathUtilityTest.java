/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huy.util.test;

import huy.util.MathUtility;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Huy
 */
public class MathUtilityTest {

    @Test  //biến hàm ở trong class này thành public static void main()
    //nhờ bộ thư viện JUnit.
    //tại sao cần vậy, vì mặc định app từ main() chuẩn
    //trong khi đó mình cần test thử hàm thoy, ko can thiệp main()
    //vậy mình cần main() khác, @Test giúp điều đó
    //nhưng vì có nhiều main() CPU bị bối rối khi nhấn F6
    //F6 dành cho main() default
    //shift F6 dành cho bên này

    //cú pháp đặt tên hàm dùng đẻ test hàm khác của dân QC
    public void getFactorial_RunsWell_IfValidArgument() {
//        assertEquals(120, MathUtility.getFactorial(5));
//        assertEquals(720, MathUtility.getFactorial(6));
//        assertEquals(24, MathUtility.getFactorial(4));
//        assertEquals(6, MathUtility.getFactorial(3));
        assertEquals(1, MathUtility.getFactorial(0));

    }
    //bắt ngoại lệ thế nào???
    //Ngoại lệ Exception ko phải là 1 value để mà so sánh
    //do đó dùng hàm assertX() là không được, vì ko là value để lo
    //ta phải dùng kĩ thuật khác
    @Test(expected = IllegalArgumentException.class)
    public void getFactorial_ThrowsException_IfInvalidArgument(){
        MathUtility.getFactorial(-5);
    }
}

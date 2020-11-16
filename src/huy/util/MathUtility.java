/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huy.util;

/**
 *
 * @author Huy
 */
public class MathUtility {
    //mình sẽ làm class này fake y chang class Math của JDK
    //Math.Pi . abs() .sqrt() .pow() .sin()
    //cái gì mà là đồ xài chung, không lưu trữ riêng lẻ info ta sẽ 
    //chơi static
    public static final double PI = 3.1415;
    //xài MathUtility.PI y chang Math.PI
    
    //hàm tính n! = 1.2.3.4...n
    //n phải >= 0, 0! = 1! = 1; quy ước
    //n! tăng nhanh, cho nên 21! tràn long rồi
    //ta chỉ tính n! từ 0..20
    //Ngoài vùng này, dù âm hay lố 20, éo tính, chửi = Exception
    //ko thèm trả về -1 hàm ý giá trị ko xài
    //học cách ném ngoại lệ luôn
    //thứ 2 ông viết tiếp, cấm vắng mặt
    public static long getFactorial(int n) {
        if ( n < 0 || n > 20) {
            throw new IllegalArgumentException("n must be between 0..20");
            
        }
        
        if (n == 0 || n == 1) 
            return 1; //1 lệnh trong if không xài ngoặc
        
        
        //chỗ này thằng nào xài else trừ điểm 
        //ngay chỗ này chính là n = 2..20
        long result = 1;
        for (int i = 2; i < n; i++) 
            result *= i;
            
        return result;
    }
}

//ta tự tin gáy hàm ta chạy ngon, chạy đúng
//nhưng: team thì cần chứng minh điều đó, đảm bảo chất lượng code, chất lượng hđ
//muốn chứng minh hàm chạy đúng hay ko ta cần test thử 
//test nghĩa là đưa hàm ra xài, gọi với các tham số khác nhau
//ví dụ gọi hàm getFactorial(với các số khác nhau đưa vào)
//getF(-5), get F(-1) getF(0), getF(5), getF(20), getF(21), ...
//các giá trị đầu vào đại diện cho việc xài hàm
//ta còn gọi là test cases, các tình huống cần test, các tình huống xài hàm
//khi ta test hàm, ta cần quan tâm 2 việc
//1. dự kiến hàm trả về giá trị gì khi hàm chạy với 1 đầu vào nào đó
//   dự kiến hàm trả về giá trịm tui gọi là EXPECTED VALUE
//   ví du: hàm sẽ trả về 120 khi gọi getF(5!)
//2. hàm khi chạy với 1 đầu vào nào đó, thì nó sẽ ói/return về 1 value
// cái value trả về của hàm khi chạy đc gọi là ACTUAL VALUE

//NGHỀ TEST CHÍNH LÀ: SO SÁNH COI EXPECTED VALUE CÓ BẰNG VỚI ACTUAL VALUE HEM?
//NẾU CÓ BẰNG, HÀM ĐÚNG CHO CASE/ TÌNH HUỐNG NÀY
//NẾU KO BẰNG, HÀM TÍNH TOÁN SAI, HOẶC KÌ VỌNG SAI

//HÀM MÀ TỐT THÌ PHẢI LÀ EXPECTED == ACTUAL MỌI TÌNH HUỐNG
//NẾU TỐT TA MỚI ĐEM RA XÀI, BÁN, PUBLIC CỘNG ĐỒNG XÀI

//LÀM SAO ĐỂ TEST HÀM COI CÓ TỐT KO, EXPECTED == ACTUAL
//HAI KĨ THUẬT ĐƯỢC ÁP DỤNG
//KĨ THUẬT 1: Nhìn bnagwf mắt và so sánh từng cặp expected vs. actual
//            chính là kĩ thuật sout(expected), sout(actual-hàm ói về gì khi chạy)
//kĩ thuật này đơn giản dễ làm nhưng mà hay sai sot do có quá nhiều cặp
//expected actual cần so sánh bằng mắt

//Kĩ Thuật 2: nhìn bằng mắt, ko cần so sánh từng capwjm để máy so sánh giùm luôn
//         mắt chỉ nhìn 2 màu XANH- ĐỎ DUY NHẤT
//nếu tất cả các cặp actual vs. expected đều thỏa, MÀU XANH CHO TÁT CẢ 
//nếu hầu hết các cặp actual vs. expected đều thỏa, có 1 vài cái ko thỏa
//THÌ KẾT LUẬN NGÀY, HÀM SAI, MÀU ĐỎ CHO TẤT CẢ
//điều này giải thích là: đúng thì phải đúng cho tất cả mọi tình huống hàm chạy
//chỉ cần 1 thằng sai, hàm sai

//tương đương câu: hàm tui chạy ngon lắm, đúng 99.9%, lâu lâu sai tí 
//nói câu đó: hàm éo tin cậy để xài
//KĨ THUẬT 2 NÀY DÙNG MÀU SẮC, MÚN LÀM VẬY THÌ PHẢI XÀI THƯ VIỆN BỔ SUNG THÊM
//CHÍNH LÀ FILE .JAR .DLL ĐC CUNG CẤP THÊM NGOÀI JDK
//Các thư viện này tùy thuộc ngôn ngữ lập trình, đc gọi chung là 
//Unit Test framework,
//C#: thư viện cụ thể NUnit, MSUnit, xUnit
//Java: Thư viện cụ thể JUnit, TestNG, xUnit
//PHP:  PHPUnit
//C++: CPPUNIT
//..
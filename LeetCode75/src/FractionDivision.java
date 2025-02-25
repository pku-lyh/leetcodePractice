import java.util.HashMap;
import java.util.Map;

/**
 * @author pku-lyh
 * @Description 描述
 * @date 2025/2/24 22:07
 */
public class FractionDivision {
    public static String fractionToDecimal(int a, int b) {
        // 处理零的情况
        if (a == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        // 处理正负号
        if (a < 0 ^ b < 0) {
            sb.append("-");
        }
        int A = Math.abs(a);
        int B = Math.abs(b);
        // 处理整数部分
        sb.append(A / B);
        A %= B;
        sb.append(".");
        Map<Integer, Integer> map = new HashMap<>();
        while (A != 0) {
            if (map.containsKey(A)) {
                sb.append("(").append(map.get(A));
                sb.append(")");
                return sb.toString();
            }
            map.put(A, sb.length());
            A *= 10;
            sb.append(A / B);
            A %= B;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int a = 1, b = 6;
        System.out.println(fractionToDecimal(a, b));  // 输出 "0.(1)"

        a = 4;
        b = 333;
        System.out.println(fractionToDecimal(a, b));  // 输出 "0.(012)"

        a = 1;
        b = 2;
        System.out.println(fractionToDecimal(a, b));  // 输出 "0.5"
    }
}

/**
 *
 */
package org.rash.interview;

/**
 * @author Ammi
 */
public class NumericalLogicalQuestions {
    public static void evenAndOddNumbers(int l) {

        for (int i = 1; i <= l; i++) {
            if (i % 2 == 0) {
                System.out.println("even Number " + i);
            } else {
                System.out.println("odd Number " + i);
            }
        }
    }

    public static void primeNumbers(int l) {
        for (int j = 1; j <= l; j++) {
            int c = 0;
            for (int i = 1; i <= j / 2; i++) {
                if (j % i == 0) {
                    c++;
                }
                if (c > 2)
                    break;
            }
            if (c == 1)
                System.out.println(j);
        }
    }

    public static int power(int n, int p) {
        int mul = 1;
        if (n >= 0 && p >= 0) {
            for (int i = 1; i <= p; i++) {
                mul = mul * n;
            }
            return mul;
        }
        return 0;
    }

    public static int numberOfDigits(int n) {
        int count;
        for (count = 0; n > 0; n /= 10)
            count++;
        return count;
    }

    public static int sumOfDigits(int n) {
        int sum;
        for (sum = 0; n > 0; n /= 10)
            sum += (n % 10);
        return sum;
    }

    public static int[] digitsOfGivenNumber(int n) {
        int numberOfDigits = numberOfDigits(n);
        int a[] = new int[numberOfDigits];
        for (int i = numberOfDigits - 1; n > 0; n /= 10, i--)
            a[i] = n % 10;
        return a;
    }

    public static void palindromNumbers(int l) {
        for (int reverseNumber, i = 1; i <= l; i++) {
            reverseNumber = 0;
            for (int t = i; t > 0; t = t / 10) {
                reverseNumber = (reverseNumber * 10) + (t % 10);
            }
            if (i == reverseNumber) {
                System.out.println(i);
            }
        }
    }

    public static void armStrongNumbers(int l) {
        int digits = String.valueOf(l).length();
        for (int i = 1, sumofCubes; i <= l; i++) {
            sumofCubes = 0;
            for (int r, t = i; t > 0; t /= 10) {
                r = t % 10;
                sumofCubes = (int) Math.pow(r, digits) + sumofCubes;
            }
            if (i == sumofCubes)
                System.out.println(i);
        }

    }

    public static void strongNumbers(int l) {
        for (int i = 1, sumofFactorials; i <= l; i++) {
            sumofFactorials = 0;
            for (int t = i, factorial, r; t > 0; t /= 10) {
                r = t % 10;
                factorial = 1;
                for (int k = 1; k <= r; k++) {
                    factorial = factorial * k;
                }
                sumofFactorials += factorial;
            }
            if (i == sumofFactorials)
                System.out.println(i);
        }

    }

    public static void perfectNumbers(int l) {
        for (int j = 1, sumOfDivisors; j <= l; j++) {
            sumOfDivisors = 0;
            for (int i = 1; i <= j / 2; i++) {
                if (j % i == 0) {
                    sumOfDivisors += i;
                }
            }
            if (j == sumOfDivisors)
                System.out.println(j);
        }

    }

    public static void fibonacciSeries(int f1, int f2, int l) {
        for (int i = 1; i <= l / 2; i++) {
            System.out.print(f1 + "\t" + f2 + "\t");
            f1 += f2;
            f2 += f1;
        }
    }

    public static int fibonacci(int number) {
        if (number == 1 || number == 2) {
            return 1;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    public static void fibnociiSeries(int n) {
        int f1 = 1, f2 = 1, f3;
        for (int i = 1; i <= n; i++) {
            System.out.print(f1 + " ");
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
    }

    public static void swapping(int a, int b) {
        System.out.println(a + "\t" + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a + "\t" + b);

    }

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return (n - 1) + (n - 2);
    }

    public static int gcd(int x, int y) {
        int r = 0, a, b;
        a = (x > y) ? x : y; // a is greater number
        b = (x < y) ? x : y; // b is smaller number
        r = b;
        while (a % b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return r;
    }

    public static int lcm(int x, int y) {
        int a, b, lcm;
        a = (x > y) ? x : y;
        b = (x < y) ? x : y;
        // First approach
        for (int i = 1; i <= x * y; i++) {
            if ((a * i) % b == 0) {
                return a * i;
            }
        }
        // second approach
        lcm = x * y / gcd(x, y);
        return lcm;
    }

    public static void pattern1() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*\t");
            }
            System.out.println("\n");
        }
    }

    public static void pattern2() {
        for (int i = 0, k = 0; i < 5; i++) {
            for (int j = 0; j <= k; j++) {
                System.out.print("*\t");
            }
            k = k + 2;
            System.out.println("\n");
        }
    }

    public static void pattern3() {
        for (int i = 0; i < 5; i++) {
            for (int j = 4; j > i; j--) {
                System.out.print("\t");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
    }

    public static void pattern4() {
        for (int i = 0, k = 1; i < 5; i++) {
            for (int j = 0; j <= i; j++, k++) {
                System.out.print(k + "\t");
            }
            System.out.println();
        }
    }

    public static void pattern5() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0, k = 1; j <= i; j++, k++) {
                System.out.print(k + "\t");
            }
            System.out.println();
        }
    }

    public static void pyramid() {

    }

    public static void diamond() {

    }

    /*
     * 1 1 1 1 2 1 1 3 3 1
     */
    public static void pascalTriangle() {

    }

    public static void binarySum(int a, int b) {
        int i = 0, carry = 0;
        int sum[] = new int[20];
        for (; a != 0 || b != 0; a /= 10, b /= 10, i++) {
            int r1 = a % 10;
            int r2 = b % 10;
            sum[i] = (r1 + r2 + carry) % 2;
            carry = (r1 + r2 + carry) / 2;
        }
        if (carry != 0)
            sum[i++] = carry;
        --i;
        while (i >= 0)
            System.out.printf("%d", sum[i--]);
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = 0;

            if (i >= 0 && a.charAt(i) == '1') {
                sum++;
            }

            if (j >= 0 && b.charAt(j) == '1') {
                sum++;
            }

            sum += carry;

            if (sum >= 2) {
                carry = 1;
            } else {
                carry = 0;
            }

            sb.insert(0, (char) ((sum % 2) + '0'));

            i--;
            j--;
        }

        if (carry == 1)
            sb.insert(0, '1');

        return sb.toString();
    }

    public static void main(String[] args) {
        binarySum(111, 11);
    }

    public boolean isRamanujanNumber() {
        return false;
    }

}

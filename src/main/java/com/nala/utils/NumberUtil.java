package com.nala.utils;


import java.math.BigDecimal;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author: heshangqiu
 * Created Date:  2018/3/14
 * <p>
 * 数字处理工具类
 * <p>
 * 注：商品购买成功后，返还积分时按照 1元 = 1积分 的规则返还
 * 购买商品消耗积分时，按照 1积分 = 1分 的规则计算
 */
public class NumberUtil {

    /**
     * 默认保留的小数位数
     */
    static public final   int  DEFAULT_DIV_SCALE = 4;
    public final static int ONE_SCALE = 1;
    public final static int INTEGER_SCALE = 0;
    public final static String YUAN_FORMAT_PATTEN = "#0.00";
    public final static String INTEGER_FORMAT_PATTEN = "#0";
    public final static SecureRandom random = new SecureRandom();
    public final static Pattern pattern = Pattern.compile("[0-9]*");
    public final static Pattern pureDigitalPattern = Pattern.compile("\\d+");
    public final static Pattern numberPattern = Pattern.compile("^(0|[1-9][0-9]*|-[1-9][0-9]*)$");

    /**
     * 分 -> 元 ， 保留2位小数
     *
     * @param num
     * @return
     */
    public static BigDecimal toYuan(String num) {
        BigDecimal b = new BigDecimal(num);
        BigDecimal hundred = new BigDecimal("100");
        return b.divide(hundred, DEFAULT_DIV_SCALE, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 转换double变量的小数位
     *
     * @param num   源double数据
     * @param scale 保留小数位数
     * @return
     */
    public static Double formatDouble(double num, int scale) {
        BigDecimal b = new BigDecimal(num);
        BigDecimal hundred = new BigDecimal("1");
        return b.divide(hundred, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 厘 -> 元, 向上取整
     *
     * @param num
     * @return
     */
    public static BigDecimal litoYuan(long num) {
        BigDecimal b = new BigDecimal(Long.toString(num));
        BigDecimal hundred = new BigDecimal("1000");
        return b.divide(hundred, DEFAULT_DIV_SCALE, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 厘 -> 元, 向上取整
     *
     * @param num
     * @return
     */
    public static Double litoYuanDouble(long num) {
        return litoYuan(num).doubleValue();
    }


    /**
     * 微厘 -> 元, 向上取整
     *
     * @param num
     * @return
     */
    public static BigDecimal wltoYuan(long num) {
        BigDecimal b = new BigDecimal(Long.toString(num));
        BigDecimal hundred = new BigDecimal("10000");
        return b.divide(hundred, DEFAULT_DIV_SCALE, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 微厘 -> 元, 向上取整
     *
     * @param num
     * @return
     */
    public static BigDecimal wltoYuan(BigDecimal bigDecimal) {
        BigDecimal hundred = new BigDecimal("10000");
        return bigDecimal.divide(hundred, DEFAULT_DIV_SCALE, BigDecimal.ROUND_HALF_UP);
    }



    /**
     * @param num
     * @return
     */
    public static Double wltoYuanDouble(long num) {
        BigDecimal b = new BigDecimal(Long.toString(num));
        BigDecimal hundred = new BigDecimal("10000");
        return b.divide(hundred, DEFAULT_DIV_SCALE, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * @param num
     * @return
     */
    public static Double wltoYuanDouble(Double num) {
        BigDecimal b = new BigDecimal(Double.toString(num));
        BigDecimal hundred = new BigDecimal("10000");
        return b.divide(hundred, DEFAULT_DIV_SCALE, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 分 -> 元, 向上取整
     *
     * @param num
     * @return
     */
    public static BigDecimal toYuanInteger(long num) {
        BigDecimal b = new BigDecimal(Long.toString(num));
        BigDecimal hundred = new BigDecimal("100");
        return b.divide(hundred, INTEGER_SCALE, BigDecimal.ROUND_UP);
    }

    /**
     * 分 -> 元，保留4位小数
     *
     * @param num
     * @return
     */
    public static BigDecimal toYuan(BigDecimal num) {
        if (num != null) {
            BigDecimal hundred = new BigDecimal("100");
            return num.divide(hundred, DEFAULT_DIV_SCALE, BigDecimal.ROUND_HALF_UP);
        }
        return null;
    }

    /**
     * 分 -> 元，保留4位小数
     *
     * @param num
     * @return
     */
    public static BigDecimal toYuan(Double num) {
        if (num != null) {
            BigDecimal numb = new BigDecimal(num);
            BigDecimal hundred = new BigDecimal("100");
            return numb.divide(hundred, DEFAULT_DIV_SCALE, BigDecimal.ROUND_HALF_UP);
        }
        return null;
    }

    /**
     * 分 -> 元，向上取整
     *
     * @param num
     * @return
     */
    public static BigDecimal toYuanInteger(BigDecimal num) {
        if (num != null) {
            BigDecimal hundred = new BigDecimal("100");
            return num.divide(hundred, INTEGER_SCALE, BigDecimal.ROUND_UP);
        }
        return null;
    }

    /**
     * 分 -> 元 ， 保留2位小数
     * （注：若结果为整数，则为 xx.0 ）
     *
     * @param num
     * @return
     */
    public static double toYuanDouble(long num) {
        return toYuan(Long.toString(num)).doubleValue();
    }

    /**
     * 分 -> 元，舍去小数位
     *
     * @param num
     * @return
     */
    public static long toYuanLong(long num) {
        return toYuan(Long.toString(num)).longValue();
    }

    /**
     * 分 -> 元，舍去小数位
     *
     * @param num
     * @return
     */
    public static long toYuanLong(String num) {
        return toYuan(num).longValue();
    }

    /**
     * 分 -> 元 ，按格式需求显示金额字符串
     *
     * @param num
     * @param pattern
     * @return
     */
    public static String toYuanStr(long num, String pattern) {
        return new DecimalFormat(pattern).format(toYuan(Long.toString(num)));
    }

    public static String format(double num) {
        return new DecimalFormat("##.##").format(num);
    }

    /**
     * 微厘-》元 保留两位小数
     *
     * @param num
     * @return
     */
    public static String wltoYuanStr(long num, String pattern) {
        return new DecimalFormat(YUAN_FORMAT_PATTEN).format(wltoYuan(num));
    }

    /**
     * 微厘-》元 保留两位小数
     *
     * @param num
     * @param pattern
     * @return
     */
    public static String wlToYuanStr(double num, String pattern) {
        return new DecimalFormat(pattern).format(NumberUtil.wltoYuanDouble(num));
    }

    /**
     * 分 -> 元 ，向上取整,按格式需求显示金额字符串
     *
     * @param num
     * @param pattern
     * @return
     */
    public static String toYuanStrInteger(long num, String pattern) {
        return new DecimalFormat(pattern).format(toYuanInteger(num));
    }

    /**
     * 分 -> 元 ，保留2位小数，并格式化为 xx.00
     *
     * @param num
     * @return
     */
    public static String toYuanStr(long num) {
        return toYuanStr(num, YUAN_FORMAT_PATTEN);
    }

    /**
     * 分 -> 元 ，向上取整，并格式化为 xx.00
     *
     * @param num
     * @return
     */
    public static String toYuanStrInteger(long num) {
        return toYuanStrInteger(num, YUAN_FORMAT_PATTEN);
    }

    /**
     * 分 -> 元, 保留2位小数，并格式化为 xx.00
     *
     * @param num
     * @return
     */
    public static String toYuanStr(BigDecimal num) {
        return new DecimalFormat(YUAN_FORMAT_PATTEN).format(toYuan(num));
    }

    /**
     * 分 -> 元, 向上取整，并格式化为 xx.00
     *
     * @param num
     * @return
     */
    public static String toYuanStrInteger(BigDecimal num) {
        return new DecimalFormat(YUAN_FORMAT_PATTEN).format(toYuanInteger(num));
    }

    /**
     * 元 -> 分
     *
     * @param num
     * @return
     */
    public static BigDecimal toFen(String num) {
        BigDecimal b = new BigDecimal(num);
        BigDecimal hundred = new BigDecimal("100");
        BigDecimal one = new BigDecimal("1");
        return b.multiply(hundred).divide(one, INTEGER_SCALE, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 元 -> 厘
     *
     * @param num
     * @return
     */
    public static BigDecimal toLi(String num) {
        BigDecimal b = new BigDecimal(num);
        BigDecimal hundred = new BigDecimal("1000");
        BigDecimal one = new BigDecimal("1");
        return b.multiply(hundred).divide(one, INTEGER_SCALE, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 元 -> 厘
     *
     * @param num
     * @return
     */
    public static Long toLiLong(Double num) {
        return toLi(Double.toString(num)).longValue();
    }

    /**
     * 元 -> 微厘
     *
     * @param num
     * @return
     */
    public static BigDecimal toWl(String num) {
        BigDecimal b = new BigDecimal(num);
        BigDecimal hundred = new BigDecimal("10000");
        BigDecimal one = new BigDecimal("1");
        return b.multiply(hundred).divide(one, INTEGER_SCALE, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 元 -> 分
     *
     * @param num
     * @return
     */
    public static long toFenLong(double num) {
        return toFen(Double.toString(num)).longValue();
    }

    /**
     * 元 -> 分
     *
     * @param num
     * @return
     */
    public static double toFenDouble(double num) {
        return toFen(Double.toString(num)).doubleValue();
    }

    /**
     * 元 -> 微厘
     *
     * @param num
     * @return
     */
    public static Long toWl(double num) {
        return toWl(Double.toString(num)).longValue();
    }






    /**
     * 元 -> 微厘
     *
     * @param num
     * @return
     */
    public static Long toWlLong(String num) {
        return toWl(num).longValue();
    }

    /**
     * 求百分比
     *
     * @param dividen 被除数
     * @param divisor 除数
     * @return
     */
    public static String toPercent(long dividen, long divisor) {
        BigDecimal dividenDecimal = new BigDecimal(Long.toString(dividen));
        if (divisor == 0L) {
            return "";
        }
        BigDecimal divisorDecimal = new BigDecimal(Long.toString(divisor));
        BigDecimal hundred = new BigDecimal("100");
        return dividenDecimal.multiply(hundred).divide(divisorDecimal, DEFAULT_DIV_SCALE, BigDecimal.ROUND_HALF_UP).toString() + "%";
    }

    /**
     * @param dividen
     * @param divisor
     * @return
     */
    public static String toPercentReverce(long dividen, long divisor) {
        BigDecimal dividenDecimal = new BigDecimal(Long.toString(dividen));
        if (divisor == 0L) {
            return "";
        }
        BigDecimal divisorDecimal = new BigDecimal(Long.toString(divisor));
        BigDecimal hundred = new BigDecimal("100");
        return (hundred.subtract(dividenDecimal.multiply(hundred).divide(divisorDecimal, DEFAULT_DIV_SCALE, BigDecimal.ROUND_HALF_UP))).toString() + "%";
    }

    /**
     * 小数转换为百分比
     *
     * @param num
     * @return
     */
    public static String toPercent(BigDecimal num) {
        if (num != null) {
            BigDecimal one = new BigDecimal("1");
            BigDecimal hundred = new BigDecimal("100");
            return num.multiply(hundred).divide(one, DEFAULT_DIV_SCALE, BigDecimal.ROUND_HALF_UP).toString() + "%";
        }
        return "";
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double getDoubleValue(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static long getLongValue(long v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Long.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).longValue();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param v 需要四舍五入的数字
     * @return 四舍五入后的结果
     */
    public static int round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).intValue();
    }

    /**
     * 根据毫秒数，获得秒数
     *
     * @param millis
     * @return
     */
    public static long getSecbyMillis(long millis) {
        return new BigDecimal(millis).divide(new BigDecimal("1000"), INTEGER_SCALE, BigDecimal.ROUND_HALF_UP).longValue();
    }

    public static String wltoYuanStr(long num) {
        BigDecimal b = new BigDecimal(Long.toString(num));
        BigDecimal hundred = new BigDecimal("10000");
        return b.divide(hundred, DEFAULT_DIV_SCALE, BigDecimal.ROUND_HALF_UP).toString();
    }

    public static Long getMax(Long v1, Long v2) {
        if (v1 > v2) {
            return v1;
        } else {
            return v2;
        }
    }

    public static Long getMin(Long v1, Long v2) {
        if (v1 > v2) {
            return v2;
        } else {
            return v1;
        }
    }

    public static boolean isNotNullOrZero(Object o) {
        return !NumberUtil.isNullOrZero(o);
    }

    public static boolean isNullOrZero(Object o) {
        if (null == o) {
            return true;
        }
        if (o instanceof Long) {
            return 0L == (Long) o;
        } else if (o instanceof Integer) {
            return 0 == (Integer) o;
        } else if (o instanceof Double) {
            return 0 == (Double) o;
        } else if (o instanceof Float) {
            return 0 == (Float) o;
        }
        return false;
    }

    /**
     * 两个数相除保留两位小数
     *
     * @param v1
     * @param v2
     * @return
     */
    public static Double getDivideDate(Long v1, Long v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.divide(b2, DEFAULT_DIV_SCALE, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static Double getDivideDate(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, DEFAULT_DIV_SCALE, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 除法, 默认保留两位小数, 四舍五入
     *
     * @param string
     * @param coefficient
     * @return
     */
    public static BigDecimal divideBy(String string, int coefficient) {

        BigDecimal b = new BigDecimal(string);
        BigDecimal bdCoefficient = new BigDecimal(coefficient);
        return b.divide(bdCoefficient, DEFAULT_DIV_SCALE, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal divideBy(Long aLong, int coefficient) {
        return divideBy(Long.toString(aLong), coefficient);
    }

    /**
     * 乘法
     *
     * @param string
     * @param coefficient
     * @return
     */
    public static BigDecimal multiplyBy(String string, int coefficient) {

        BigDecimal b = new BigDecimal(string);
        BigDecimal bdCoefficient = new BigDecimal(coefficient);
        return b.multiply(bdCoefficient);
    }

    public static BigDecimal multiplyBy(Long aLong, int coefficient) {
        return multiplyBy(Long.toString(aLong), coefficient);
    }

    /**
     * 两个数相除保留两位小数
     *
     * @param v1
     * @param v2
     * @return
     */
    public static Double getDivideDate2(Long v1, Long v2, int num) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        if ("0".equals(String.valueOf(b2))) {
            return 0.00;
        }
        return b1.divide(b2, num, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static Double getDivideDate2(String v1, String v2, int num) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        if ("0".equals(String.valueOf(b2)) || "0.00".equals(String.valueOf(b2))) {
            return 0.00;
        }
        return b1.divide(b2, num, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param v 需要四舍五入的数字
     * @return 四舍五入后的结果
     */
    public static double round1(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static int discount(int discount) {
        if (discount % 10 == 0) {
            return discount / 10;
        }
        return discount;
    }

    /**
     * 两个Double数相加
     *
     * @param v1
     * @param v2
     * @return
     */
    public static Double add(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.add(b2).doubleValue();
    }

    /**
     * 两个Double数相加
     *
     * @param v1
     * @param v2
     * @return Double
     */
    public static Double add(Double v1, Double v2) {
        return add(v1.toString(), v2.toString());
    }

    /**
     * 两个Double数相减
     *
     * @param v1
     * @param v2
     * @return Double
     */
    public static Double sub(Double v1, Double v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 两个Double数相乘
     *
     * @param v1
     * @param v2
     * @return Double
     */
    public static Double mul(Double v1, Double v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 两个Double数相乘且保留小数
     *
     * @param v1
     * @param v2
     * @return Double
     */
    public static Double mul(Double v1, Double v2, int scale) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.multiply(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 两个Double数相除
     *
     * @param v1
     * @param v2
     * @return Double
     */
    public static Double div(Double v1, Double v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.divide(b2, 10, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 两个Double数相除，并保留scale位小数
     *
     * @param v1
     * @param v2
     * @param scale
     * @return Double
     */
    public static Double div(Double v1, Double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }



    /**
     * 匹配是否为数字
     * @param str 可能为中文，也可能是-19162431.1254，不使用BigDecimal的话，变成-1.91624311254E7
     * @return
     */
    public static boolean isNumeric(String str) {
        // 该正则表达式可以匹配所有的数字 包括负数
        Pattern pattern = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
        String bigStr;
        try {
            bigStr = new BigDecimal(str).toString();
        } catch (Exception e) {
            return false;//异常 说明包含非数字。
        }

        Matcher isNum = pattern.matcher(bigStr); // matcher是全匹配
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     * 匹配是否为数包括科学计数法
     * @param str
     * @return
     */
    public static boolean isNumericWithScientificNotation(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        String regx = "[+-]*\\d+\\.?\\d*[Ee]*\\d+";
        Pattern pattern = Pattern.compile(regx);
        boolean isNumber = pattern.matcher(str).matches();
        if (isNumber) {
            return isNumber;
        }
        regx = "^[-\\+]?[.\\d]*$";
        pattern = Pattern.compile(regx);
        return pattern.matcher(str).matches();
    }

    /**
     * 生成不重复随机数 根据给定的最小数字和最大数字，以及随机数的个数，产生指定的不重复的数组
     *
     * @param begin 最小数字（包含该数）
     * @param end   最大数字（不包含该数）
     * @param size  指定产生随机数的个数
     * @return 随机int数组
     */
    public static int[] generateRandomNumber(int begin, int end, int size) {
        if (begin > end) {
            int temp = begin;
            begin = end;
            end = temp;
        }
        // 加入逻辑判断，确保begin<end并且size不能大于该表示范围
        if ((end - begin) < size) {
            throw new RuntimeException("Size is larger than range between begin and end!");
        }
        // 种子你可以随意生成，但不能重复
        int[] seed = new int[end - begin];

        for (int i = begin; i < end; i++) {
            seed[i - begin] = i;
        }
        int[] ranArr = new int[size];
        Random ran = new Random();
        // 数量你可以自己定义。
        for (int i = 0; i < size; i++) {
            // 得到一个位置
            int j = ran.nextInt(seed.length - i);
            // 得到那个位置的数值
            ranArr[i] = seed[j];
            // 将最后一个未用的数字放到这里
            seed[j] = seed[seed.length - 1 - i];
        }
        return ranArr;
    }
}

/**
 * 异常机制练习 try‑catch‑finally、throw、throws、自定义异常
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            int res = divide(10,0);
            System.out.println(res);
        }catch (ArithmeticException e){
            System.out.println("捕获算术异常："+e.getMessage());
        }catch (MyBizException e){
            System.out.println("捕获业务异常："+e.getMessage());
        }finally {
            System.out.println("finally总会执行");
        }
    }

    public static int divide(int a,int b) throws MyBizException{
        if(b==0){
            throw new MyBizException("除数不能为0");
        }
        return a/b;
    }

    //自定义受检异常
    static class MyBizException extends Exception{
        public MyBizException(String msg){ super(msg); }
    }
}
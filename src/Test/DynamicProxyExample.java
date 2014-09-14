package Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Intellij IEDA.
 * DATE : 2014/7/31
 * TIME : 14:47
 * AUTHOR : Allen.Xue
 * E-MAIL : xuezy90@gmail.com
 */
public class DynamicProxyExample {
    public static void main(String[] args) {
        CaculatorProtocol server = new Server();
        InvocationHandler handler = new CaculatorHandler(server);
        CaculatorProtocol client = (CaculatorProtocol)Proxy.newProxyInstance(server.getClass().getClassLoader(),
                server.getClass().getInterfaces(),handler);
        System.out.println(client.add(5,3));
    }
}
class CaculatorHandler implements InvocationHandler
{
    private Object objOriginal;
    public CaculatorHandler(Object obj)
    {
        this.objOriginal = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(this.objOriginal,args);
        return result;
    }
}
class Server implements CaculatorProtocol
{

    @Override
    public int add(int a, int b) {
        return a+b;
    }
}
interface CaculatorProtocol
{
    public int add(int a,int b);
}
package Student.DataStructure;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Hashtable是原始的java.util的一部分， 是一个Dictionary具体的实现 。
 *
 */
public class HashtableStudent {

    public static void main(String[] args){
        //建立哈希表
        //1、默认构造方法的哈希表
        Hashtable balance = new Hashtable();

        //2、指定大小的哈希表
        //Hashtable balance = new Hashtable(2);

        //3、指定大小的哈希表，并通过fillRatio指定填充比例
        // (填充比例必须介于0.0和1.0之间，它决定了哈希表在重新调整大小之前的充满程度：)
        //Hashtable balance = new Hashtable(4,4);

        //4、创建一个以M中元素为初始化元素的哈希表
        // （哈希表容量被设置为M的两倍）
        //Map M = new HashMap()
        //Hashtable balance = new Hashtable(M);

        //定义枚举 储存键名
        Enumeration names;
        //定义短暂字符串储存器
        String str;
        //定义短暂Double储存器
        double bal;

        //哈希表添加元素
        balance.put("King", new Double(9999.99));
        balance.put("David", new Double(6666.66));
        balance.put("Tom", new Double(4444.44));

        System.out.println(balance.toString());
        //获取哈希表的KEY
        names = balance.keys();
        while(names.hasMoreElements()){
            str = (String)names.nextElement();
            System.out.println(str + "：" + balance.get(str));
        }

        //将1000元存入King的账户
        bal = ((Double)balance.get("King")).doubleValue();
        balance.put("King", new Double(bal + 1000));
        System.out.println("King new balance：" + balance.get("King"));

    }
}

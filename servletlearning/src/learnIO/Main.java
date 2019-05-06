import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;

class MyClass<T> implements Cloneable, Serializable {
    private int id = -1;
    private String name = "Unknown";
    public MyClass(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String toString() {
        return "MyClass: id=" + this.id + ", name=" + this.name;
    }
}

public class Main {
    public static void main(String[] args) {
        // Print the class declaration for the Class class
        String classDesciption = getClassDescription(MyClass.class);
        System.out.println(classDesciption);
    }

    public static String getClassDescription(Class c) {
        StringBuilder classDesc = new StringBuilder();
        int modifierBits = 0;
        String keyword = "";

        // 返回修饰词
        if (c.isInterface()) {
            modifierBits = c.getModifiers() & Modifier.interfaceModifiers();
            if (c.isAnnotation()) {
                keyword = "@interface";
            } else {
                keyword = "interface";
            }
        } else if (c.isEnum()) {
            modifierBits = c.getModifiers() & Modifier.classModifiers();
            keyword = "enum";
        }else{
            modifierBits = c.getModifiers() & Modifier.classModifiers();
            keyword = "class";
        }

        // 修饰词变成字符串
        String modifiers = Modifier.toString(modifierBits);
        classDesc.append(modifiers);
        classDesc.append(" " + keyword);
        // 获取类的简单名字
        String simpleName = c.getSimpleName();
        classDesc.append(" " + simpleName);
        // 获取类的泛型参数
        String genericParms = getGenericTypeParams(c);
        System.out.println(genericParms);
        classDesc.append(genericParms);
        // 获取超类
        Class superClass = c.getSuperclass();
        System.out.println(superClass);
        if (superClass != null) {
            String superClassSimpleName = superClass.getSimpleName();
            classDesc.append("  extends " + superClassSimpleName);
        }
        String interfaces = Main.getClassInterfaces(c);
        if (interfaces != null) {
            classDesc.append("  implements " + interfaces);
        }
        return classDesc.toString();
    }

    public static String getClassInterfaces(Class c) {
        Class[] interfaces = c.getInterfaces();
        String interfacesList = null;
        if (interfaces.length > 0) {
            String[] interfaceNames = new String[interfaces.length];
            for (int i = 0; i < interfaces.length; i++) {
                interfaceNames[i] = interfaces[i].getSimpleName();
            }
            interfacesList = String.join(", ", interfaceNames);
        }
        return interfacesList;
    }

    public static String getGenericTypeParams(Class c) {
        StringBuilder sb = new StringBuilder();
        TypeVariable<?>[] typeParms = c.getTypeParameters();

        if (typeParms.length > 0) {
            String[] paramNames = new String[typeParms.length];
            for (int i = 0; i < typeParms.length; i++) {
                paramNames[i] = typeParms[i].getTypeName();
            }
            sb.append("<");
            String parmsList = String.join(",", paramNames);
            sb.append(parmsList);
            sb.append(">");
        }
        return sb.toString();
    }
}
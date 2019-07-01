package api.demo;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-6-30 15:05
 * @Version 1.0
 */
public enum  SchemaType {

    IP("ip"),
    DIGEST("digest"),
    WORLD("world"),
    SUPER("super");

    private String type;

    SchemaType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
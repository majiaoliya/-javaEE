package demo1;

public @interface BookAnno {
    String value();
    double price() default 100;
    String[] authors() default {"曹雪芹", "老王"};
    StringBuilder sb = null;
}

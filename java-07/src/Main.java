public class Main {
    public static void main(String[] args) {
        Student arr[] = new Student[4];
//        for(int i=0; i<arr.length; i++)
//            arr[i] = new Student(i+"", i+17, i&1);
        arr[0] = new Student("张山", 17, 1);
        arr[0] = new Student("王山", 17, 1);
        arr[0] = new Student("李山", 17, 1);
    search_by_pre_name(arr, "张");
    }

    public static Student search_by_pre_name(Student arr[], String str) {
        Student ret = null;
        for(int i=0; i<arr.length; i++)
            if(null != arr[i] && arr[i].name.startsWith(str)) {
                ret = arr[i];
                break;
            }
        return ret;
    }
}

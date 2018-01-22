package com.laibao.springaop.jdkdynamicproxy.util;

public class PerformanceMonitor {

    private static ThreadLocal<MethodPerformance> performanceRecorde = new ThreadLocal<>();

    public static void beginMonitor(String method) {
        System.out.println("begin to monitor ....");
        MethodPerformance performance = new MethodPerformance(method);
        performanceRecorde.set(performance);
    }

    public static void endMonitor() {
        System.out.println("end monotor ...");
        MethodPerformance performance = performanceRecorde.get();
        performance.printPerformance();
    }


    private static class MethodPerformance{
        private long beginTime;
        private long endTime;
        private String serviceMethod;

        public MethodPerformance(String serviceMethod) {
            this.serviceMethod = serviceMethod;
            this.beginTime = System.currentTimeMillis();
        }

        public void printPerformance() {
            this.endTime = System.currentTimeMillis();
            long elapse = this.endTime - this.beginTime;
            System.out.println(this.serviceMethod + "花费了" + elapse + "毫秒");
        }

    }
}

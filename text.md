## Java中与线程池相关的类

*  Executor
*  ExecutorService
*  ScheduledExecutorService
*  ThreadPoolExecutor
*  ScheduledThreadPoolExecutor
*  Executors

## Executors工具类
**Executors类**是一个创建线程池的有用的类，Executors类的作用是创建线程池，它是一个工厂类，可以产生不同类型的线程池。

## 常见的几种线程池 ##
1.newCachedThreadPool():创建一个可缓存线程池，应用中存在的线程数可以无限大，
该线程池比较适合没有固定大小并且比较快速就能完成的小任务，它将为每个任务创建一个线程。那这样子它与直接创建线程对象（new Thread()）有什么区别呢？看到它的第三个参数60L和第四个参数TimeUnit.SECONDS了吗？好处就在于60秒内能够重用已创建的线程。
````java
public static ExecutorService newCachedThreadPool() {  
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());  
    } 
````
CachedThreadPool：无界线程池，可以进行自动线程回收。
如果线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，此线程池又可以智能的添加新线程来处理任务。此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。SynchronousQueue是一个是缓冲区为1的阻塞队列。

2.newFixedThreadPool(int nThreads):使用的Thread对象的数量是有限的,如果提交的任务数量大于限制的最大线程数，那么这些任务讲排队，然后当有一个线程的任务结束之后，将会根据调度策略继续等待执行下一个任务。
FixedThreadPool：只有核心线程的线程池,大小固定 (其缓冲队列是无界的) 。
````java
public static ExecutorService newFixedThreadPool(int nThreads) {  
      return new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());  
  }
````
创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
3.newSingleThreadExecutor():
就是线程数量为1的FixedThreadPool,如果提交了多个任务，那么这些任务将会排队，每个任务都会在下一个任务开始之前运行结束，所有的任务将会使用相同的线程。
SingleThreadExecutor：单个后台线程 (其缓冲队列是无界的)
````java
public static ExecutorService newSingleThreadExecutor() {  
        return new FinalizableDelegatedExecutorService  
            (new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()));  
    } 
````
创建一个单线程的线程池。这个线程池只有一个核心线程在工作，也就是相当于单线程串行执行所有任务。如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
4.newScheduledThreadPool(int corePoolSize):
创建一个固定长度的线程池，而且以延迟或定时的方式来执行任务。
ScheduledThreadPool：核心线程池固定，大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。
````java
public static ExecutorService newScheduledThreadPool(int corePoolSize) {         
    return new ScheduledThreadPool(corePoolSize, 
              Integer.MAX_VALUE,                                                  
              DEFAULT_KEEPALIVE_MILLIS, MILLISECONDS,                                                    
              new DelayedWorkQueue());    
}
````
创建一个周期性执行任务的线程池。如果闲置,非核心线程池会在DEFAULT_KEEPALIVEMILLIS时间内回收。

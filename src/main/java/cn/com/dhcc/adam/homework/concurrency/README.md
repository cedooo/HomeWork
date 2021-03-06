 <ul>
 <li>Processes and Threads</li>
 <li>two basic strategies</li> 
 <li>sleep()</li>
 <li>join()</li>
 <li>Synchronization</li> 
 <li>synchronized methods</li> 
 <li>synchronized statements</li>
 <li>Atomic Access</li>
 <li>
 <p>
 intrinsic lock / monitor lock<br />
 Every object has an intrinsic lock associated with it. By convention, a thread that needs exclusive and consistent access to an object's fields has to acquire the object's intrinsic lock before accessing them, and then release the intrinsic lock when it's done with them.
 </p>
 <p>
  there are actions you can specify that are atomic:
	<ol>
	<li>Reads and writes are atomic for reference variables and for most primitive variables (all types except long and double).</li>
	<li>Reads and writes are atomic for all variables declared volatile (including long and double variables).</li>
	</ol>
 </p>
 </li>
 <li>
 <p>
 Liveness<br />
 A concurrent application's ability to execute in a timely manner is known as its liveness.
 <a target="_blank" href="https://docs.oracle.com/javase/tutorial/essential/concurrency/liveness.html">☞</a>
 </p>
<ol>
 <li>
 <b>Starvation</b>: ... unable to gain regular access to shared resources and is unable to make progress. 
 <a target="_blank" href="https://docs.oracle.com/javase/tutorial/essential/concurrency/starvelive.html">☞</a>
 </li>
 <li>
 <b>Livelock</b>: A thread often acts in response to the action of another thread. 
 If the other thread's action is also a response to the action of another thread, then livelock may result. As with deadlock,
  livelocked threads are unable to make further progress. However, the threads are not blocked ... <a target="_blank" href="https://docs.oracle.com/javase/tutorial/essential/concurrency/starvelive.html">☞</a>
 </li>
 </ol>
 </p>
 </li>
 <li>
 Guarded blocks <a target="_blank" href="https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html">☞</a>/<a target="_blank" href="http://ifeve.com/oracle-guarded-blocks/">☞-CN</a>,
  Immutable objects
 </li>
 <li>
 <b>High level concurrency objects</b><br />
 <code>java.util.concurrent</code>
 </li>
 <li>
 Executors
	<ol>
	<li>
		Executor Interfaces</li>
	<li>
		Thread Pools. <a href="http://www.infoq.com/cn/articles/java-threadPool" >extra @infoQ</a><br/>
		<img src="http://cdn1.infoqstatic.com/statics_s2_20150902-03315u4/resource/articles/java-threadPool/zh/resources/threadpool.jpg" />
	</li>
	<li>Fork/Join</li>
	</ol>
 </li>
 </ul>
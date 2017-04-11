package console;

import engine.Calculate;

public class OutputTips
{
	String out=null;
		public void tempinit (String[] t)
    {
		System.out.printf("%-15s%s\n",t[0],"-水质");
		System.out.printf("%-15s%s\n",t[1],"-工艺");
		System.out.printf("%-15s%s\n",t[2],"-结果");
		System.out.printf("%-15s%s\n",t[3]+ "," + t[4],"-退出程序");
    }
    public void operate (String[] o,String tem1,String instr)
    {
		if(instr.equals(tem1)){
			System.out.printf("%-14s%s\n",o[0],"-查看");
			System.out.printf("%-14s%s\n",o[1],"-设置");
			System.out.printf("%-14s%s\n",o[2]+ "," + o[3],"-退出程序");
		}else{
			out=instr;
			System.out.printf("%-8s%-14s%s\n", out ,o[0],"-查看");
			System.out.printf("%-8s%-14s%s\n", out ,o[1],"-设置");
			System.out.printf("%-8s%-14s%s\n", out ,o[2]+ "," + o[3],"-退出程序");
		}
		
    }
    
    public void result (String tem1,String instr,String[] re)
    {
    	
		if(tem1.equals("result")){
			System.out.printf("%-14s%s\n",re[0],"-查看计算结果");
			System.out.printf("%-14s%s\n",re[2]+ "," + re[3],"-退出程序");
		}else{
			out=instr;
			System.out.printf("%-7s%-14s%s\n", out ,re[0],"-查看计算结果");
			System.out.printf("%-7s%-14s%s\n", out ,re[2]+ "," + re[3],"-退出程序");
		}
		
    
    }
    
    public void str2 (String[] s,String tem1,String instr,String[] re)
    {
    	System.out.println("下列指令有效：");
    	if(tem1.equals("water")){
	    	System.out.printf("%-5s%-17s%s\n",re[0],s[0], "-查看进水浓度");
	    	System.out.printf("%-5s%-17s%s\n",re[0],s[1], "-查看温度");
	    	System.out.printf("%-5s%-17s%s\n",re[0],s[2], "-查看污染因子");
	    	System.out.printf("%-5s%-17s%s\n",re[0],s[3], "-查看pH");
		}else{
			out=instr;
	    	System.out.printf("%-6s%-5s%-17s%s\n", out ,re[0],s[0], "-查看进水浓度");
	    	System.out.printf("%-6s%-5s%-17s%s\n", out ,re[0],s[1], "-查看温度");
	    	System.out.printf("%-6s%-5s%-17s%s\n", out ,re[0],s[2], "-查看污染因子");
	    	System.out.printf("%-6s%-5s%-17s%s\n", out ,re[0],s[3], "-查看pH");
		}
    }
    
    public void str22 (String[] s,int num,String tem1,String instr,String[] re)
    {
    	System.out.println("下列指令有效：");
     	if(tem1.equals("process")){
			if(num==1)
	    	{   
	    		System.out.printf("%-5s%-19s%s\n",re[0],s[0], "-查看系统段数");
	        	System.out.printf("%-5s%-19s%s\n",re[0],s[1], "-查看一段压力容器数");
	        	System.out.printf("%-5s%-19s%s\n",re[0],s[2], "-查看一段压力容器内膜元件数");
	        	System.out.printf("%-5s%-19s%s\n",re[0],s[6], "-查看膜元件类型");
	        	System.out.printf("%-5s%-19s%s\n",re[0],s[7], "-查看系统产水量");
	        	System.out.printf("%-5s%-19s%s\n",re[0],s[8], "-查看系统回收率");
			}
	    	else
	    	{  
	    		System.out.printf("%-5s%-19s%s\n",re[0],s[0], "-查看系统段数");
	        	System.out.printf("%-5s%-19s%s\n",re[0],s[1], "-查看一段压力容器数");
	        	System.out.printf("%-5s%-19s%s\n",re[0],s[2], "-查看一段压力容器内膜元件数");
	        	System.out.printf("%-5s%-19s%s\n",re[0],s[3], "-查看二段压力容器数");
	        	System.out.printf("%-5s%-19s%s\n",re[0],s[4], "-查看二段压力容器内膜元件数");
	        	System.out.printf("%-5s%-19s%s\n",re[0],s[5], "-查看段间增压");
	        	System.out.printf("%-5s%-19s%s\n",re[0],s[6], "-查看膜元件类型");
	        	System.out.printf("%-5s%-19s%s\n",re[0],s[7], "-查看系统产水量");
	        	System.out.printf("%-5s%-19s%s\n",re[0],s[8], "-查看系统回收率");
	    	}
		}else{
			out=instr;
			if(num==1)
	    	{   
	    		System.out.printf("%-8s%-5s%-19s%s\n", out ,re[0],s[0], "-查看系统段数");
	        	System.out.printf("%-8s%-5s%-19s%s\n", out ,re[0],s[1], "-查看一段压力容器数");
	        	System.out.printf("%-8s%-5s%-19s%s\n", out ,re[0],s[2], "-查看一段压力容器内膜元件数");
	        	System.out.printf("%-8s%-5s%-19s%s\n", out ,re[0],s[6], "-查看膜元件类型");
	        	System.out.printf("%-8s%-5s%-19s%s\n", out ,re[0],s[7], "-查看系统产水量");
	        	System.out.printf("%-8s%-5s%-19s%s\n", out ,re[0],s[8], "-查看系统回收率");
			}
	    	else
	    	{  
	    		System.out.printf("%-8s%-5s%-19s%s\n", out ,re[0],s[0], "-查看系统段数");
	        	System.out.printf("%-8s%-5s%-19s%s\n", out ,re[0],s[1], "-查看一段压力容器数");
	        	System.out.printf("%-8s%-5s%-19s%s\n", out ,re[0],s[2], "-查看一段压力容器内膜元件数");
	        	System.out.printf("%-8s%-5s%-19s%s\n", out ,re[0],s[3], "-查看二段压力容器数");
	        	System.out.printf("%-8s%-5s%-19s%s\n", out ,re[0],s[4], "-查看二段压力容器内膜元件数");
	        	System.out.printf("%-8s%-5s%-19s%s\n", out ,re[0],s[5], "-查看段间增压");
	        	System.out.printf("%-8s%-5s%-19s%s\n", out ,re[0],s[6], "-查看膜元件类型");
	        	System.out.printf("%-8s%-5s%-19s%s\n", out ,re[0],s[7], "-查看系统产水量");
	        	System.out.printf("%-8s%-5s%-19s%s\n", out ,re[0],s[8], "-查看系统回收率");
	    	}
		}
    	
    }
    
    public void res (String[] r,String tem1,String instr,String[] re)
    {
    	System.out.println("下列指令有效：");
    	if(tem1.equals("result")){
			System.out.printf("%-5s%-17s%s\n",re[0],r[0], "-查看系统计算结果");
	    	System.out.printf("%-5s%-17s%s\n",re[0],r[1], "-查看段内详细计算结果");
	    	System.out.printf("%-5s%-17s%s\n",re[0],r[2], "-查看预警");
		}else{
			out=instr;
			System.out.printf("%-7s%-5s%-17s%s\n", out ,re[0],r[0], "-查看系统计算结果");
	    	System.out.printf("%-7s%-5s%-17s%s\n", out ,re[0],r[1], "-查看段内详细计算结果");
	    	System.out.printf("%-7s%-5s%-17s%s\n", out ,re[0],r[2], "-查看预警");
		}
    }
    public void str2Set (String[] s,String tem1,String instr,String[] re,String[] input,int len)
    {
    	if(len==1||(Calculate.CheckMatch(s, input[1]).size()==0&&len==2)){
       	if (tem1.equals("water")) {
    		System.out.printf("%-4s%-16s%-14s%s\n",re[1],s[0], "<number>","-设定进水浓度的值且number大于0");
	    	System.out.printf("%-4s%-16s%-14s%s\n",re[1],s[1], "<number>","-设定温度的值且number在[1,99]之间");
	    	System.out.printf("%-4s%-16s%-14s%s\n",re[1],s[2], "<number>","-设定污染因子的值");
	    	System.out.printf("%-4s%-16s%-14s%s\n",re[1],s[3], "<number>","-设定pH的值且number在[0,14]之间");
		} else{
			out =instr;
	    	System.out.printf("%-6s%-4s%-16s%-14s%s\n", out ,re[1],s[0], "<number>","-设定进水浓度的值且number大于0");
	    	System.out.printf("%-6s%-4s%-16s%-14s%s\n", out ,re[1],s[1], "<number>","-设定温度的值且number在[1,99]之间");
	    	System.out.printf("%-6s%-4s%-16s%-14s%s\n", out ,re[1],s[2], "<number>","-设定污染因子的值");
	    	System.out.printf("%-6s%-4s%-16s%-14s%s\n", out ,re[1],s[3], "<number>","-设定pH的值且number在[0,14]之间");
		}
    	}else if(Calculate.CheckMatch(s, input[1]).size()>0&&len==2){
        	if (tem1.equals("water")) {
    			if (Calculate.MatchString(s[0], input[1])) {
    				System.out.printf("%-4s%-4s%-14s%s\n",re[1], s[0],
    						"<number>", "-设定进水浓度的值且number大于0");
    			} else if (Calculate.MatchString(s[1], input[1])) {
    				System.out.printf("%-4s%-12s%-14s%s\n",re[1], s[1],
    						"<number>", "-设定温度的值且number在[1,99]之间");
    			} else if (Calculate.MatchString(s[2], input[1])) {
    				System.out.printf("%-4s%-16s%-14s%s\n",re[1], s[2],
    						"<number>", "-设定污染因子的值");
    			} else if (Calculate.MatchString(s[3], input[1])) {
    				System.out.printf("%-4s%-3s%-14s%s\n",re[1], s[3],
    						"<number>", "-设定pH的值且number在[0,14]之间");
    			}
    		} else {
    			out = instr;
    			if (Calculate.MatchString(s[0], input[1])) {
    				System.out.printf("%-6s%-4s%-4s%-14s%s\n", out,re[1], s[0],
    						"<number>", "-设定进水浓度的值且number大于0");
    			} else if (Calculate.MatchString(s[1], input[1])) {
    				System.out.printf("%-6s%-4s%-12s%-14s%s\n", out,re[1],
    						s[1], "<number>", "-设定温度的值且number在[1,99]之间");
    			} else if (Calculate.MatchString(s[2], input[1])) {
    				System.out.printf("%-6s%-4s%-16s%-14s%s\n", out,re[1],
    						s[2], "<number>", "-设定污染因子的值");
    			} else if (Calculate.MatchString(s[3], input[1])) {
    				System.out.printf("%-6s%-4s%-3s%-14s%s\n", out,re[1], s[3],
    						"<number>","-设定pH的值且number在[0,14]之间");
    			}
    		}
        }
    	
 
    }
   
    public void str22Set (String[] s,int num,String tem1,String instr,String[] re,String[] input,int len)
    {
    	if(len==1||(Calculate.CheckMatch(s, input[1]).size()==0&&len==2)){
		if (tem1.equals("process")) {
			if (num== 1) {
				System.out.printf("%-4s%-20s%-14s%s\n",re[1],s[0], "<number>","-设定系统段数的值且number等于1或2");
				System.out.printf("%-4s%-20s%-14s%s\n",re[1],s[1], "<number>","-设定一段压力容器数的值且number大于0");
				System.out.printf("%-4s%-20s%-14s%s\n",re[1],s[2], "<number>","-设定一段压力容器内膜元件数的值且number大于0");
				System.out.printf("%-4s%-20s%-14s%s\n",re[1],s[6], "<number>","-设定膜元件类型且number等于BW_8040或SW_8040或ULP_8040");
				System.out.printf("%-4s%-20s%-14s%s\n",re[1],s[7], "<number>","-设定系统产水量的值且number大于0");
				System.out.printf("%-4s%-20s%-14s%s\n",re[1],s[8], "<number>","-设定系统回收率的值且number在(0,1)之间");
			} else {
				System.out.printf("%-4s%-20s%-14s%s\n",re[1],s[0], "<number>","-设定系统段数的值且number等于1或2");
				System.out.printf("%-4s%-20s%-14s%s\n",re[1],s[1], "<number>","-设定一段压力容器数的值且number大于0");
				System.out.printf("%-4s%-20s%-14s%s\n",re[1],s[2], "<number>","-设定一段压力容器内膜元件数的值且number大于0");
				System.out.printf("%-4s%-20s%-14s%s\n",re[1],s[3], "<number>","-设定二段压力容器数的值且number大于0");
				System.out.printf("%-4s%-20s%-14s%s\n",re[1],s[4], "<number>","-设定二段压力容器内膜元件数的值且number大于0");
				System.out.printf("%-4s%-20s%-14s%s\n",re[1],s[5], "<number>","-设定段间增压的值且number大于等于0");
				System.out.printf("%-4s%-20s%-14s%s\n",re[1],s[6], "<number>","-设定膜元件类型且number等于BW_8040或SW_8040或ULP_8040");
				System.out.printf("%-4s%-20s%-14s%s\n",re[1],s[7], "<number>","-设定系统产水量的值且number大于0");
				System.out.printf("%-4s%-20s%-14s%s\n",re[1],s[8], "<number>","-设定系统回收率的值且number在(0,1)之间");
			}
		} else {
			out = instr;
			if (num== 1) {
				System.out.printf("%-8s%-4s%-20s%-14s%s\n", out ,re[1],s[0], "<number>","-设定系统段数的值且number等于1或2");
				System.out.printf("%-8s%-4s%-20s%-14s%s\n", out ,re[1],s[1], "<number>","-设定一段压力容器数的值且number大于0");
				System.out.printf("%-8s%-4s%-20s%-14s%s\n", out ,re[1],s[2], "<number>","-设定一段压力容器内膜元件数的值且number大于0");
				System.out.printf("%-8s%-4s%-20s%-14s%s\n", out ,re[1],s[6], "<number>","-设定膜元件类型且number等于BW_8040或SW_8040或ULP_8040");
				System.out.printf("%-8s%-4s%-20s%-14s%s\n", out ,re[1],s[7], "<number>","-设定系统产水量的值且number大于0");
				System.out.printf("%-8s%-4s%-20s%-14s%s\n", out ,re[1],s[8], "<number>","-设定系统回收率的值且number在(0,1)之间");
			} else {
				System.out.printf("%-8s%-4s%-20s%-14s%s\n", out ,re[1],s[0], "<number>","-设定系统段数的值且number等于1或2");
				System.out.printf("%-8s%-4s%-20s%-14s%s\n", out ,re[1],s[1], "<number>","-设定一段压力容器数的值且number大于0");
				System.out.printf("%-8s%-4s%-20s%-14s%s\n", out ,re[1],s[2], "<number>","-设定一段压力容器内膜元件数的值且number大于0");
				System.out.printf("%-8s%-4s%-20s%-14s%s\n", out ,re[1],s[3], "<number>","-设定二段压力容器数的值且number大于0");
				System.out.printf("%-8s%-4s%-20s%-14s%s\n", out ,re[1],s[4], "<number>","-设定二段压力容器内膜元件数的值且number大于0");
				System.out.printf("%-8s%-4s%-20s%-14s%s\n", out ,re[1],s[5], "<number>","-设定段间增压的值且number大于等于0");
				System.out.printf("%-8s%-4s%-20s%-14s%s\n", out ,re[1],s[6], "<number>","-设定膜元件类型且number等于BW_8040或SW_8040或ULP_8040");
				System.out.printf("%-8s%-4s%-20s%-14s%s\n", out ,re[1],s[7], "<number>","-设定系统产水量的值且number大于0");
				System.out.printf("%-8s%-4s%-20s%-14s%s\n", out ,re[1],s[8], "<number>","-设定系统回收率的值且number在(0,1)之间");
			}
		}
    }
    else if(Calculate.CheckMatch(s, input[1]).size()>0&&len==2){
    	if (tem1.equals("process")) {
			if (Calculate.MatchString(s[0], input[1])) {
				System.out.printf("%-4s%-9s%-14s%s\n",re[1], s[0],
						"<number>", "-设定系统段数的值且number等于1或2");
			} else if (Calculate.MatchString(s[1], input[1])) {
				System.out.printf("%-4s%-12s%-14s%s\n",re[1], s[1],
						"<number>", "-设定一段压力容器数的值且number大于0");
			} else if (Calculate.MatchString(s[2], input[1])) {
				System.out.printf("%-4s%-7s%-14s%s\n",re[1], s[2],
						"<number>", "-设定一段压力容器内膜元件数的值且number大于0");
			} else if (Calculate.MatchString(s[3], input[1])) {
				System.out.printf("%-4s%-12s%-14s%s\n",re[1], s[3],
						"<number>", "-设定二段压力容器数的值且number大于0");
			} else if (Calculate.MatchString(s[4], input[1])) {
				System.out.printf("%-4s%-7s%-14s%s\n",re[1], s[4],
						"<number>", "-设定二段压力容器内膜元件数的值且number大于0");
			} else if (Calculate.MatchString(s[5], input[1])) {
				System.out.printf("%-4s%-20s%-14s%s\n",re[1], s[5],
						"<number>", "-设定段间增压的值且number大于等于0");
			} else if (Calculate.MatchString(s[6], input[1])) {
				System.out.printf("%-4s%-7s%-14s%s\n",re[1], s[6],
						"<number>", "-设定膜元件类型且number等于BW_8040或SW_8040或ULP_8040");
			} else if (Calculate.MatchString(s[7], input[1])) {
				System.out.printf("%-4s%-7s%-14s%s\n",re[1], s[7],
						"<number>", "-设定系统产水量的值且number大于0");
			} else if (Calculate.MatchString(s[8], input[1])) {
				System.out.printf("%-4s%-14s%-14s%s\n",re[1], s[8],
						"<number>", "-设定系统回收率的值且number在(0,1)之间");
			}
		} else {
			out = instr;
			if (Calculate.MatchString(s[0], input[1])) {
				System.out.printf("%-8s%-4s%-9s%-14s%s\n",out,re[1],
						s[0], "<number>", "-设定系统段数的值且number等于1或2");
			} else if (Calculate.MatchString(s[1], input[1])) {
				System.out.printf("%-8s%-4s%-12s%-14s%s\n", out,re[1],
						s[1], "<number>", "-设定一段压力容器数的值且number大于0");
			} else if (Calculate.MatchString(s[2], input[1])) {
				System.out.printf("%-8s%-4s%-7s%-14s%s\n", out,re[1],
						s[2], "<number>", "-设定一段压力容器内膜元件数的值且number大于0");
			} else if (Calculate.MatchString(s[3], input[1])) {
				System.out.printf("%-8s%-4s%-12s%-14s%s\n", out,re[1],
						s[3], "<number>", "-设定二段压力容器数的值且number大于0");
			} else if (Calculate.MatchString(s[4], input[1])) {
				System.out.printf("%-8s%-4s%-7s%-14s%s\n", out,re[1],
						s[4], "<number>", "-设定二段压力容器内膜元件数的值且number大于0");
			} else if (Calculate.MatchString(s[5], input[1])) {
				System.out.printf("%-8s%-4s%-20s%-14s%s\n", out,re[1],
						s[5], "<number>", "-设定段间增压的值且number大于等于0");
			} else if (Calculate.MatchString(s[6], input[1])) {
				System.out.printf("%-8s%-4s%-7s%-14s%s\n", out,re[1],
						s[6], "<number>",
						"-设定膜元件类型且number等于BW_8040或SW_8040或ULP_8040");
			} else if (Calculate.MatchString(s[7], input[1])) {
				System.out.printf("%-8s%-4s%-7s%-14s%s\n", out,re[1],
						s[7], "<number>", "-设定系统产水量的值且number大于0");
			} else if (Calculate.MatchString(s[8], input[1])) {
				System.out.printf("%-8s%-4s%-14s%-14s%s\n", out,re[1],
						s[8], "<number>", "-设定系统回收率的值且number在(0,1)之间");
			}
		}
    }
    }
}

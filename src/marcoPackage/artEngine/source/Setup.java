package marcoPackage.artEngine.source;


import java.io.BufferedReader; 
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Setup {
	final String SETUP_PATH="C:\\Users\\marco\\Desktop\\Eclipse Workspace\\Art_Engine_ultimate_edition\\assets\\setup.txt";
	int MAX_IMAGE_AMOUNT;
	int NUMBER_OF_LEVEL;
	int IMAGE_HEIGHT;
	int IMAGE_WIDTH;
	String resultPath;
	String metaPath;
	ArrayList<String> paths;
	ArrayList<Integer> n_files;
	HashMap<String,HashMap<String,Integer>> rarities;
	ArrayList<String> trait_types;
	ArrayList<ArrayList<String>> variants;
	
	Setup() throws IOException{
		
		this.paths=new ArrayList<String>();
		this.n_files=new ArrayList<Integer>();
		this.rarities=new HashMap<String,HashMap<String,Integer>>();
		this.trait_types=new ArrayList<String>();
		this.variants= new ArrayList<ArrayList<String>>();
		
		File t=new File(SETUP_PATH);
		FileReader r=new FileReader(t);
		BufferedReader reader= new BufferedReader(r);
		
		
		String line= reader.readLine();
		line=line.substring(line.indexOf("=")+2,line.length());
		this.MAX_IMAGE_AMOUNT=Integer.parseInt(line);
		
		
	    line= reader.readLine();
		line=line.substring(line.indexOf("=")+2,line.length());
		this.NUMBER_OF_LEVEL=Integer.parseInt(line);
		
		line= reader.readLine();
		line=line.substring(line.indexOf("=")+2,line.length());
		this.IMAGE_WIDTH=Integer.parseInt(line);
		
		line= reader.readLine();
		line=line.substring(line.indexOf("=")+2,line.length());
		this.IMAGE_HEIGHT=Integer.parseInt(line);
		
		
		line= reader.readLine();
		
		if(this.MAX_IMAGE_AMOUNT>0){
			
			for(int i=0;i<this.NUMBER_OF_LEVEL;i++) {
				line= reader.readLine();
				line=line.substring(line.indexOf("=")+2,line.length());
				this.paths.add(i, line);
				
				
				this.n_files.add(i, new File(paths.get(i)).listFiles().length);
				
				
				line=reader.readLine();
				String trait_type=line.substring(line.indexOf(" ")+1,line.indexOf("=")-1);
				this.trait_types.add(i,trait_type);
				HashMap<String,Integer> temp= new HashMap<String,Integer>();
				ArrayList<String> te=new ArrayList<String>();
				
				for(int j=0;j<this.n_files.get(i);j++) {
					line=reader.readLine();
					String variant=line.substring(0,line.indexOf(" "));
					int value=Integer.parseInt(line.substring(line.indexOf(" ")+1,line.length()));
					temp.put(variant, value);
					te.add(j,variant);
				}
				this.rarities.put(trait_type, temp);
				this.variants.add(i,te);
				line=reader.readLine();
			}
		}
		
		else { 
			for(int i=0;i<this.NUMBER_OF_LEVEL;i++) {
			line=reader.readLine();
			line=line.substring(line.indexOf("=")+2,line.length());
			this.paths.add(i,line);
			
			this.n_files.add(i, new File(this.paths.get(i)).listFiles().length);
			
			line=reader.readLine();
			this.trait_types.add(i,line);
			ArrayList<String> temp=new ArrayList<String>();
			for(int j=0;j<this.n_files.get(i);j++) {
				line=reader.readLine();
				temp.add(j,line);
			}
			this.variants.add(i,temp);
			
			line=reader.readLine();
			}
		
		}
		
		line=reader.readLine();
		line=line.substring(line.indexOf("=")+2,line.length());
		this.resultPath=line;
		
		line=reader.readLine();
		line=line.substring(line.indexOf("=")+2,line.length());
		this.metaPath=line;
		
		reader.close();
	}
	
	
	
	void checkSetup() {
		
		System.out.println(this.MAX_IMAGE_AMOUNT);
		System.out.println(this.NUMBER_OF_LEVEL);
		System.out.println(this.IMAGE_WIDTH);
		System.out.println(this.IMAGE_HEIGHT);
		System.out.println(this.metaPath);
		System.out.println(this.resultPath);
		
		for(int i=0;i<this.paths.size();i++) 
			System.out.println(this.paths.get(i));
		
		for(int i=0;i<this.n_files.size();i++) 
			System.out.println(this.n_files.get(i));
		
		
		for(int i=0;i<this.trait_types.size();i++) {
			System.out.println("trait_type: "+this.trait_types.get(i));
			for(int j=0;j<this.variants.get(i).size();j++) {
				System.out.println("        variant: "+this.variants.get(i).get(j));
			}
		}
		
		
		if(this.MAX_IMAGE_AMOUNT>0) {
		for(String trait_type: this.rarities.keySet()) {
			System.out.println("Trait_type: "+trait_type);
			for(String variant:this.rarities.get(trait_type).keySet()) {
				System.out.println("       variant: "+variant+" "+this.rarities.get(trait_type).get(variant));
			}
		}
	}
	}
}

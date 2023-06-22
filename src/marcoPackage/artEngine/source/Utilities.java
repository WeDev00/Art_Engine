package marcoPackage.artEngine.source;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;

import javax.imageio.ImageIO;
public class Utilities {
	
	Setup setup;
	ArrayList<ArrayList<Integer>> max_count;

	Utilities(Setup setup){
		this.setup=setup;
		
		this.max_count=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<this.setup.trait_types.size();i++) {
			String trait_type=this.setup.trait_types.get(i);
			ArrayList<Integer> temp=new ArrayList<Integer>();
			System.out.println("Trait_type: "+trait_type);
			for(int j=0;j<this.setup.variants.get(i).size();j++) {
				String variant=this.setup.variants.get(i).get(j);
				int temp_max=(this.setup.MAX_IMAGE_AMOUNT* this.setup.rarities.get(trait_type).get(variant))/100;
				temp.add(j,temp_max);
				System.out.println("            variant: "+variant+": "+temp.get(j));
			}
			this.max_count.add(i,temp);
		}
		return;
	}
	
	String fileName(int pos, int i) {
		return this.setup.paths.get(pos)+"/img"+i+".png";
	}
	
	String imageResultName(int count) {
		return this.setup.resultPath+"/"+count+".png";
	}
	
	void printAndSave(Stack<BufferedImage> stack, int count,int width, int height) throws IOException {
		BufferedImage result=new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		Graphics g=result.getGraphics();
		
		for(int i=0;i<stack.size();i++) 
			g.drawImage(stack.elementAt(i), 0, 0,null);
		
		g.dispose();
		ImageIO.write(result, "png",new File(imageResultName(count)));
	}
	
	void createAndSaveMetadatas(ArrayList<Integer> layers, int count) throws FileNotFoundException {
		String text=createText(layers,count);
		PrintWriter metaFile = new PrintWriter(this.setup.metaPath+"/"+count+".json");
		metaFile.print(text);
		metaFile.close();
	}
	
	 public String createText(ArrayList<Integer> layers, int count) {
		 String s="{\n \"TokenId\": ";
		 int tokenId=count;
		 s=s+tokenId+",\n\"attributes\": [\n";
		
		String trait_type;
		String value;
		 
		 for(int i=1;i<layers.size();i++) {
			String[] result=fromCoordinateToStrings(i,layers.get(i));
			trait_type=result[0];
			value=result[1];
			
			s=s+"\t{\n\t\t\"trait_type\" : \""+trait_type+"\",\n\t\t\"value\" : \""+value+"\"\n\t}";
			
			if(i<layers.size()-1)
				s=s+",";
		 }
		 
		 s=s+"\n]\n}";
		 
		 
		 return s;
	 }
	
	String[] fromCoordinateToStrings(int i,int j) {
		String [] to_ret= {"",""};
		
		to_ret[0]=this.setup.trait_types.get(i);
		to_ret[1]=this.setup.variants.get(i).get(j);
		
		return to_ret;
	}
	
	
	
	boolean checkSolution(ArrayList<Integer> layers) {
		
		for(int i=0;i<layers.size();i++) {
			if(this.max_count.get(i).get(layers.get(i))<=0) {
				return false;
			}
		}
		
		for(int i=0;i<layers.size();i++) {
			int n=this.max_count.get(i).get(layers.get(i));
			this.max_count.get(i).set(layers.get(i), n-1);
		}
		
		return true;
	}
	
}

package marcoPackage.artEngine.source;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import javax.imageio.ImageIO;

public class Mixer {

	int count;
	Setup setup;
	Stack<BufferedImage> stack;
	ArrayList<Integer> layers;
	Utilities util;
	
	Mixer() throws IOException{
		count=0;
		setup=new Setup();
		stack= new Stack<BufferedImage> ();
		layers= new ArrayList<Integer>();
		util=new Utilities(setup);
		
	}
	
	void generate() throws IOException {
		
		if(setup.MAX_IMAGE_AMOUNT<=0)
		run_grezzo(0);
		else {
		run_filtrato(0);
		if(this.count<this.setup.MAX_IMAGE_AMOUNT)
			System.out.println("Non è stato possibile ottenere il numero di immagini richieste rispettando i vincoli dati");
		}
		
		return;
	}
	
	void run_grezzo(int pos) throws IOException {
		
		if(pos>=setup.NUMBER_OF_LEVEL) {
			util.printAndSave(stack,this.count,this.setup.IMAGE_WIDTH,this.setup.IMAGE_HEIGHT);
			util.createAndSaveMetadatas(layers, this.count);
			this.count++;
			return;
		}
		
		for(int i=0;i<setup.n_files.get(pos);i++) {
			BufferedImage toPush= ImageIO.read(new File(util.fileName(pos, i)));
			layers.add(pos,i);
			this.stack.push(toPush);
			run_grezzo(pos+1);
			layers.remove(pos);
			this.stack.pop();
		}
		
	}
	
	void run_filtrato(int pos) throws IOException {
		
		if(this.count>=this.setup.MAX_IMAGE_AMOUNT)
			return;
		
		if(pos>=this.setup.NUMBER_OF_LEVEL) {
			if(util.checkSolution(layers)) {
				util.printAndSave(stack, this.count, this.setup.IMAGE_WIDTH, this.setup.IMAGE_HEIGHT);
				util.createAndSaveMetadatas(layers, this.count);
				this.count++;
			}
		    return;
		}
		
		
		for(int i=0;i<setup.n_files.get(pos);i++) {
			BufferedImage toPush= ImageIO.read(new File(util.fileName(pos, i)));
			layers.add(pos,i);
			this.stack.push(toPush);
			run_filtrato(pos+1);
			layers.remove(pos);
			this.stack.pop();
		}
		
		return;
	}
	
}

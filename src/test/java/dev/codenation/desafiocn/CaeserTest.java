package dev.codenation.desafiocn;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CaeserTest {

	@Test
	public void encryptTest() {
		String sentence = "a ligeira raposa marrom saltou sobre o cachorro cansado";
		String result = "d oljhlud udsrvd pduurp vdowrx vreuh r fdfkruur fdqvdgr";
		assertEquals(Caesar.encrypt(sentence, 3), result);
	}

	@Test
	public void decryptTest() {
		String result = "a ligeira raposa marrom saltou sobre o cachorro cansado";
		String sentence = "d oljhlud udsrvd pduurp vdowrx vreuh r fdfkruur fdqvdgr";
		assertEquals(Caesar.decrypt(sentence, 3), result);
	}

	
	@Test
	public void test() {
		String sentence = "aa b1 c.c";
		String result = "bb c1 d.d";
		
		assertEquals(Caesar.encrypt(sentence, 1), result);
		assertEquals(Caesar.decrypt(result, 1), sentence);
	}

	
}

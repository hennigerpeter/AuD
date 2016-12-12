public class Riddle {

	public static boolean implies(boolean a, boolean b) {
		// TODO: a => b
    // nicht a oder b
    /*
    
    a/b na na or b
    0 0 1  1
    1 0 0  0
    1 1 0  1
    0 1 1  1
    
    */
    
    if (b == true)
      return true;
    else if (a == false)
      return true;
    
		return false;
	}

	public static boolean a0(boolean stan, boolean cartman, boolean kyle) {
		// TODO: A0
		// not stan => not kyle
    
    return implies(!stan, !kyle);
	}

	public static boolean a1(boolean stan, boolean cartman, boolean kyle) {
		// TODO: A1
    // not cartman => not stan
    
		return implies(!cartman, !stan);
	}

	public static boolean a2(boolean stan, boolean cartman, boolean kyle) {
		// TODO: A2
    // cartman xor kyle xor stan
    if (stan && !cartman && !kyle)
      return true;
    else if (!stan && cartman && !kyle)
      return true;
    else if (!stan && !cartman && kyle)
      return true;
    
		return false;
	}

	public static boolean a3(boolean stan, boolean cartman, boolean kyle) {
		// TODO: A3
    
    boolean z1 = implies(cartman, (!kyle && !stan));
    boolean z2 = implies(kyle, (!cartman && !stan));
    boolean z3 = implies(stan, (!cartman && !kyle));
    if(z1 && z2 && z3)
      return true;
    
		return false;
	}

	public static boolean eval(boolean stan, boolean cartman, boolean kyle) {
		// TODO: eval
    boolean a0 = a0(stan, cartman, kyle);
    boolean a1 = a1(stan, cartman, kyle);
    boolean a2 = a2(stan, cartman, kyle);
    boolean a3 = a3(stan, cartman, kyle);
    if (a0 && a1 && a2 && a3)
      return true;
    
		return false;
	}

	public static int checkRiddle() {
		// TODO: checkRiddle
    // 0=Stan, 1=cartman, 2=kyle
		
    
    if (eval(true, false, false))
      return 0;
    
    if (eval(false, true, false))
      return 1;
    
    if (eval(false, false, true))
      return 2;
    
    
    return -1;
	}
}

class Main  {
      a: Int <- 41;
      b: Int <- 2;
      c: Int <- 1;
      d: Int <- 3;
      main() : void {{
         a + b;
         c - a;
         b * c;
         d / b;
	(new Main).main();
      }};
  };
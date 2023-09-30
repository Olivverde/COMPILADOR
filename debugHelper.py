from Main import Compiler
to_compile = Compiler("test/testLet.YAPL")
print(to_compile.printer.my_errors.get_errors())
print(to_compile.codePrinter.nodes_and_codes)
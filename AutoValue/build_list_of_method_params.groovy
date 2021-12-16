import com.intellij.psi.*;
import com.intellij.psi.search.*;
def classNameParam = _1;
PsiClass mainClass = JavaPsiFacade.getInstance(_editor.project).findClass(classNameParam, GlobalSearchScope.allScope(_editor.project));
String line = '';
def allMethods = new ArrayList<PsiMethod>();
mainClass.getInterfaces().each { item ->
    allMethods.addAll(item.getMethods());
};
allMethods.addAll(mainClass.getMethods());
allMethods.each { method->
    if (method.getName()!='create') {
        line = line + method.getReturnType().getCanonicalText()+' '+method.getName()+',';
    };
};
return line.substring(0,line.length()-1);
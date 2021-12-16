import com.intellij.psi.*;
import com.intellij.psi.search.*;
def classNameParam = _1;
PsiClass mainClass = JavaPsiFacade.getInstance(_editor.project).findClass(classNameParam, GlobalSearchScope.allScope(_editor.project));
def listOfParents = [];
listOfParents.add(mainClass.getName());
PsiClass currClass = mainClass;
while (currClass.getContainingClass() != null) {
    currClass = currClass.getContainingClass();
    listOfParents.add(currClass.getName());
};
listOfParents.add('AutoValue');
return listOfParents.reverse().join('_');
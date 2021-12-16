def methodParametersList = _1;
def paramsNames = [];
methodParametersList.replace(', ', ',').split(',').each {
    paramsNames.add(it.split(' ')[1]);
};
return paramsNames.join(', ');
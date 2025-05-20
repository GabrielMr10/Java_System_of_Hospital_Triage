○ Ator: Paciente ou Atendente 
- Descrição: Permite que um paciente seja cadastrado no sistema, 
incluindo informações como nome, CPF, telefone, endereço, sintomas 
e histórico médico.

- Fluxo Principal: 

1. O sistema solicita as informações do paciente. 
2. O paciente ou atendente insere as informações. 
3. O sistema valida as informações e as armazena no banco de 
dados. 
4. O sistema exibe uma mensagem de confirmação. 
2. Classificar Paciente:

 Ator: Enfermeiro 

 Descrição: Permite que um enfermeiro classifique a prioridade de 
atendimento de um paciente com base em seus sintomas e histórico 
médico.

Fluxo Principal: 

1. O sistema exibe a lista de pacientes cadastrados. 
2. O enfermeiro seleciona um paciente. 
3. O sistema exibe as informações do paciente. 
4. O enfermeiro seleciona a prioridade de atendimento. 
5. O sistema atualiza a prioridade do paciente no banco de dados. 
6. O sistema exibe uma mensagem de confirmação. 
3. Atender Paciente:

 Ator: Enfermeiro 

 Descrição: Permite que um enfermeiro registre o atendimento de um 
paciente. 

 Fluxo Principal: 
 
1. O sistema exibe a lista de pacientes na fila de atendimento. 
2. O enfermeiro seleciona um paciente. 
3. O sistema exibe as informações do paciente. 
4. O enfermeiro registra o atendimento. 
5. O sistema atualiza o status do paciente no banco de dados. 
6. O sistema exibe uma mensagem de confirmação. 
4. Sair do Sistema:
   
Ator: Enfermeiro 

 Descrição: Permite que o enfermeiro saia do sistema. 
 
 Fluxo Principal: 
 
1. O sistema exibe uma mensagem de confirmação. 
2. O enfermeiro confirma a saída. 
3. O sistema encerra a sessão do enfermeiro.
   
Atores:

● Paciente: A pessoa que busca atendimento médico. 
● Atendente: O funcionário do hospital que cadastra os pacientes. 
● Enfermeiro: O profissional de saúde que classifica e atende os 
pacientes. 

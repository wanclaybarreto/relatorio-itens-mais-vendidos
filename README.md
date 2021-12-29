<h1>RELÁTORIO DE ITENS MAIS VENDIDOS</h1>

Página web com design responsivo criada para gerar relatórios. Ela foi feita para uma empresa de software do ramo de gestão empresarial.
Tecnologias utilizadas: Java; Spring Data JPA e outros recursos do ecossistema Spring; banco de dados MySQL; Jaspersoft Studio; Thymeleaf; HTML; CSS;
Javascript.

Vale ressaltar que os dados (logotipo, nome e outros) da empresa (cliente) em questão foram removidos por uma questão de segurança e privacidade.

<h3>O relatório:</h3>

	Os relatórios gerados são compostos pelos produtos que foram vendidos para algum cliente em determinado intervalo de tempo.

<h3>Os filtros/parâmetros:</h3>

	Cliente -> caso um cliente não seja especificado, todos os clientes são considerados no processo de criação do relatório.

	Data inicial e final -> caso nenhuma data seja especificada, todo o período existente é considerado; são consideradas apenas as vendas que
	foram feitas a partir da data inicial, caso apenas esta data seja especificada; são consideradas apenas as vendas que foram feitas até a
	data final, caso apenas esta data seja especificada; são consideradas as vendas pertencentes ao intervalo de tempo existente entre as datas
	iniciais e finais, caso ambas as datas sejam especificadas.

<h3>Diferencial do relatório:</h3>

	O produtos são ordenados de forma decrescente com relação a quantidade de unidades (UN., CS., entre outras) vendidas.
	A partir dele, é possível saber, por exemplo: quais produtos foram mais vendidos; os produtos mais comprado por cada cliente.

<h3>Observação: apesar de ter recebido uma base de dados já criada pela empresa em questão, as queries utilizadas nas classes Repository também foram feitas por mim.</h3>
<br/>

Autor: Wanclay Barreto <br/>
Github: https://github.com/wanclaybarreto
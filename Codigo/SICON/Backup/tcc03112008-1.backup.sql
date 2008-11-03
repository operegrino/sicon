PGDMP
     '                
    l           tcc    8.3.0    8.3.0 �   �           0    0    ENCODING    ENCODING !   SET client_encoding = 'WIN1252';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS )   SET standard_conforming_strings = 'off';
                       false                        2615    2200    public    SCHEMA    CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �           0    0    SCHEMA public    COMMENT 6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    6            �           0    0    public    ACL �   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                  postgres    false    6            ^           1259    27337 	   auditoria    TABLE /  CREATE TABLE auditoria (
    idauditoria integer NOT NULL,
    dataoperacao timestamp with time zone NOT NULL,
    log character varying(10) NOT NULL,
    operacao character varying(50) NOT NULL,
    dados character varying(10000) NOT NULL,
    tabela character varying(50),
    idreferencia integer
);
    DROP TABLE public.auditoria;
       public         postgres    false    6            _           1259    27343    banco    TABLE _   CREATE TABLE banco (
    nome character varying(100) NOT NULL,
    idbanco integer NOT NULL
);
    DROP TABLE public.banco;
       public         postgres    false    6            `           1259    27346    botao    TABLE �   CREATE TABLE botao (
    idbotao integer NOT NULL,
    titulobotao character varying(50),
    nomebotao character varying(50) NOT NULL,
    descricaobotao character varying(100)
);
    DROP TABLE public.botao;
       public         postgres    false    6            @           1247    27351 
   breakpoint    TYPE P   CREATE TYPE breakpoint AS (
	func oid,
	linenumber integer,
	targetname text
);
    DROP TYPE public.breakpoint;
       public       postgres    false    6    1633            b           1259    27352    cardapio    TABLE �   CREATE TABLE cardapio (
    idcardapio integer NOT NULL,
    datacardapio date NOT NULL,
    qtderefeicoes integer NOT NULL,
    idrefeicao integer NOT NULL
);
    DROP TABLE public.cardapio;
       public         postgres    false    6            c           1259    27355    cardapioficha    TABLE e   CREATE TABLE cardapioficha (
    idcardapio integer NOT NULL,
    idfichatecnica integer NOT NULL
);
 !   DROP TABLE public.cardapioficha;
       public         postgres    false    6            d           1259    27358    cargo    TABLE c   CREATE TABLE cargo (
    idcargo integer NOT NULL,
    descricao character varying(50) NOT NULL
);
    DROP TABLE public.cargo;
       public         postgres    false    6            e           1259    27361    composicaocentesimal    TABLE   CREATE TABLE composicaocentesimal (
    idcomposicaocentesimal integer NOT NULL,
    energia numeric(6,3),
    carboidrato numeric(6,3),
    proteina numeric(6,3),
    lipideo numeric(6,3),
    calcio numeric(6,3),
    ferro numeric(6,3),
    vitaminac numeric(6,3)
);
 (   DROP TABLE public.composicaocentesimal;
       public         postgres    false    6            �           1259    27988    configuracoes    TABLE �   CREATE TABLE configuracoes (
    remetente character varying(100),
    senha character varying(50),
    textomensagem character varying(500),
    titulomensagem character(100),
    idconfiguracoes integer NOT NULL
);
 !   DROP TABLE public.configuracoes;
       public         postgres    false    6            f           1259    27364    dadosbancarios    TABLE �   CREATE TABLE dadosbancarios (
    iddadosbancarios integer NOT NULL,
    idbanco integer NOT NULL,
    agencia character varying(20) NOT NULL,
    contacorrente character varying(20) NOT NULL,
    contacorrentedigito character varying(1) NOT NULL
);
 "   DROP TABLE public.dadosbancarios;
       public         postgres    false    6            g           1259    27367    email    TABLE �   CREATE TABLE email (
    idemail integer NOT NULL,
    email character varying(100) NOT NULL,
    idfornecedor integer NOT NULL
);
    DROP TABLE public.email;
       public         postgres    false    6            h           1259    27370    fichatecnica    TABLE �  CREATE TABLE fichatecnica (
    idfichatecnica integer NOT NULL,
    nomepreparacao character varying(70) NOT NULL,
    modopreparo character varying(500),
    rendimento numeric(3,1) NOT NULL,
    energia numeric(6,3),
    carboidrato numeric(6,3),
    proteina numeric(6,3),
    lipideo numeric(6,3),
    calcio numeric(6,3),
    ferro numeric(6,3),
    vitaminac numeric(6,3),
    pesocru numeric(6,3),
    pesoliquido numeric(6,3),
    precototal numeric(4,2)
);
     DROP TABLE public.fichatecnica;
       public         postgres    false    6            i           1259    27373    fichatecnicaitens    TABLE �   CREATE TABLE fichatecnicaitens (
    idfichatecnica integer NOT NULL,
    idproduto integer NOT NULL,
    pesobruto numeric(6,3),
    pesoliquido numeric(6,3),
    fatorcorrecao integer
);
 %   DROP TABLE public.fichatecnicaitens;
       public         postgres    false    6            j           1259    27376    formapagamento    TABLE �   CREATE TABLE formapagamento (
    idformapagamento integer NOT NULL,
    nome character varying(100) NOT NULL,
    operacaobancaria boolean NOT NULL
);
 "   DROP TABLE public.formapagamento;
       public         postgres    false    6            k           1259    27379    formapagamentofornecedor    TABLE �   CREATE TABLE formapagamentofornecedor (
    idformapagamentofornecedor integer NOT NULL,
    idformapagamento integer NOT NULL,
    idfornecedor integer NOT NULL
);
 ,   DROP TABLE public.formapagamentofornecedor;
       public         postgres    false    6            l           1259    27382 
   fornecedor    TABLE J  CREATE TABLE fornecedor (
    idfornecedor integer NOT NULL,
    codigo character varying(15) NOT NULL,
    razaosocial character varying(100) NOT NULL,
    cnpj character varying(14) NOT NULL,
    inscricaoestadual character varying(50),
    ccm character varying(50),
    cgc character varying(50),
    rua character varying(100) NOT NULL,
    numero character varying(10),
    bairro character varying(100),
    cidade character varying(50),
    cep character varying(50),
    site character varying(100),
    tempoentrega integer NOT NULL,
    iddadosbancarios integer DEFAULT 0
);
    DROP TABLE public.fornecedor;
       public         postgres    false    1999    6            m           1259    27386    fornecedorproduto    TABLE   CREATE TABLE fornecedorproduto (
    idfornecedorproduto integer NOT NULL,
    idproduto integer NOT NULL,
    idfornecedor integer NOT NULL,
    codprodutofornecedor character varying(10),
    tempoentrega integer,
    idtipofornecedor integer NOT NULL
);
 %   DROP TABLE public.fornecedorproduto;
       public         postgres    false    6            Z           1247    27391    frame    TYPE g   CREATE TYPE frame AS (
	level integer,
	targetname text,
	func oid,
	linenumber integer,
	args text
);
    DROP TYPE public.frame;
       public       postgres    false    6    1646            �           1259    27896    historicopedido    TABLE �   CREATE TABLE historicopedido (
    idhistoricopedido integer NOT NULL,
    idpedido integer NOT NULL,
    idsituacaopedido integer NOT NULL,
    datahistoricopedido timestamp without time zone NOT NULL
);
 #   DROP TABLE public.historicopedido;
       public         postgres    false    6            �           1259    27945    itemavaliacao    TABLE �   CREATE TABLE itemavaliacao (
    iditemavaliacao integer NOT NULL,
    iditempedido integer NOT NULL,
    idmotivo integer,
    idsituacaoitempedido integer NOT NULL,
    adequado boolean NOT NULL,
    dataavaliacao timestamp with time zone
);
 !   DROP TABLE public.itemavaliacao;
       public         postgres    false    6            �           1259    27914 
   itempedido    TABLE �   CREATE TABLE itempedido (
    iditempedido integer NOT NULL,
    idpedido integer NOT NULL,
    idproduto integer NOT NULL,
    quantidade numeric(9,3) NOT NULL,
    idunidademedida integer NOT NULL
);
    DROP TABLE public.itempedido;
       public         postgres    false    6            o           1259    27392 
   logsistema    TABLE �   CREATE TABLE logsistema (
    horario timestamp with time zone NOT NULL,
    operacao character varying(10) NOT NULL,
    logvinculado integer,
    idlogsistema integer NOT NULL,
    idusuario integer NOT NULL
);
    DROP TABLE public.logsistema;
       public         postgres    false    6            p           1259    27395 	   mensagens    TABLE �   CREATE TABLE mensagens (
    idmensagem integer NOT NULL,
    mensagem character varying(300) NOT NULL,
    tipomensagem integer DEFAULT 0 NOT NULL
);
    DROP TABLE public.mensagens;
       public         postgres    false    2003    6            q           1259    27399    motivo    TABLE ~   CREATE TABLE motivo (
    idmotivo integer NOT NULL,
    nome character varying(100) NOT NULL,
    baixar boolean NOT NULL
);
    DROP TABLE public.motivo;
       public         postgres    false    6            r           1259    27402 	   movimento    TABLE   CREATE TABLE movimento (
    idmovimento integer NOT NULL,
    idproduto integer NOT NULL,
    quantidade numeric(9,3) NOT NULL,
    idunidademedida integer NOT NULL,
    idoperacao integer NOT NULL,
    motivooperacao character varying(100),
    datamovimento date NOT NULL
);
    DROP TABLE public.movimento;
       public         postgres    false    6            s           1259    27405    operacao    TABLE �   CREATE TABLE operacao (
    idoperacao integer NOT NULL,
    descricao character varying(50) NOT NULL,
    vlfator integer NOT NULL
);
    DROP TABLE public.operacao;
       public         postgres    false    6            t           1259    27408    ordemproducao    TABLE $  CREATE TABLE ordemproducao (
    idordemproducao integer NOT NULL,
    dataordem date NOT NULL,
    idrefeicao integer NOT NULL,
    idorigemordem integer NOT NULL,
    idsituacaoordem integer NOT NULL,
    setor character varying(100) NOT NULL,
    motivo character varying(250) NOT NULL
);
 !   DROP TABLE public.ordemproducao;
       public         postgres    false    6            u           1259    27411    ordemproduto    TABLE �   CREATE TABLE ordemproduto (
    idordemproducao integer NOT NULL,
    idproduto integer NOT NULL,
    quantidade numeric(9,3) NOT NULL,
    idunidademedida integer NOT NULL,
    idordemproduto integer NOT NULL
);
     DROP TABLE public.ordemproduto;
       public         postgres    false    6            v           1259    27414    origemordem    TABLE o   CREATE TABLE origemordem (
    idorigemordem integer NOT NULL,
    descricao character varying(50) NOT NULL
);
    DROP TABLE public.origemordem;
       public         postgres    false    6            �           1259    27888    pedido    TABLE y   CREATE TABLE pedido (
    idpedido integer NOT NULL,
    idfornecedor integer NOT NULL,
    dataentrega date NOT NULL
);
    DROP TABLE public.pedido;
       public         postgres    false    6            w           1259    27417    perfil    TABLE �   CREATE TABLE perfil (
    idperfil integer NOT NULL,
    nome character varying(100) NOT NULL,
    administrador boolean NOT NULL
);
    DROP TABLE public.perfil;
       public         postgres    false    6            x           1259    27420 
   perfiltela    TABLE �   CREATE TABLE perfiltela (
    idperfiltela integer NOT NULL,
    idperfil integer NOT NULL,
    idtela integer NOT NULL,
    idbotao integer
);
    DROP TABLE public.perfiltela;
       public         postgres    false    6            y           1259    27423    produto    TABLE �  CREATE TABLE produto (
    idproduto integer NOT NULL,
    codigo character varying(10) NOT NULL,
    nome character varying(100) NOT NULL,
    valor numeric(12,2),
    estoqueminimo numeric(6,3) NOT NULL,
    qtdeembalagem numeric(6,3),
    temperaturaentrega numeric(6,2) NOT NULL,
    alimentar boolean NOT NULL,
    idcomposicaocentesimal integer,
    unidadeembalagem integer,
    unidadeestoque integer NOT NULL
);
    DROP TABLE public.produto;
       public         postgres    false    6            r           1247    27428 	   proxyinfo    TYPE �   CREATE TYPE proxyinfo AS (
	serverversionstr text,
	serverversionnum integer,
	proxyapiver integer,
	serverprocessid integer
);
    DROP TYPE public.proxyinfo;
       public       postgres    false    6    1658            {           1259    27429    refeicao    TABLE i   CREATE TABLE refeicao (
    idrefeicao integer NOT NULL,
    descricao character varying(50) NOT NULL
);
    DROP TABLE public.refeicao;
       public         postgres    false    6            |           1259    27432    saldoano    TABLE E  CREATE TABLE saldoano (
    idsaldoano integer NOT NULL,
    ano integer NOT NULL,
    saldoentrada numeric(12,3) DEFAULT 0 NOT NULL,
    saldosaida numeric(12,3) DEFAULT 0 NOT NULL,
    saldocomprometido numeric(12,3) DEFAULT 0 NOT NULL,
    saldopendente numeric(12,3) DEFAULT 0 NOT NULL,
    idproduto integer NOT NULL
);
    DROP TABLE public.saldoano;
       public         postgres    false    2015    2016    2017    2018    6            }           1259    27439    saldodia    TABLE l  CREATE TABLE saldodia (
    idsaldodia integer NOT NULL,
    datasaldodia date NOT NULL,
    saldosaida numeric(12,3) DEFAULT 0 NOT NULL,
    saldoentrada numeric(12,3) DEFAULT 0 NOT NULL,
    saldocomprometido numeric(12,3) DEFAULT 0 NOT NULL,
    saldopendente numeric(12,3) DEFAULT 0 NOT NULL,
    idsaldomes integer NOT NULL,
    idproduto integer NOT NULL
);
    DROP TABLE public.saldodia;
       public         postgres    false    2020    2021    2022    2023    6            ~           1259    27446    saldomes    TABLE f  CREATE TABLE saldomes (
    idsaldomes integer NOT NULL,
    mes integer NOT NULL,
    idsaldoano integer NOT NULL,
    saldoentrada numeric(12,3) DEFAULT 0 NOT NULL,
    saldosaida numeric(12,3) DEFAULT 0 NOT NULL,
    saldocomprometido numeric(12,3) DEFAULT 0 NOT NULL,
    saldopendente numeric(12,3) DEFAULT 0 NOT NULL,
    idproduto integer NOT NULL
);
    DROP TABLE public.saldomes;
       public         postgres    false    2025    2026    2027    2028    6            �           1259    36188    situacaoitempedido    TABLE ~   CREATE TABLE situacaoitempedido (
    idsituacaoitempedido integer NOT NULL,
    descricao character varying(100) NOT NULL
);
 &   DROP TABLE public.situacaoitempedido;
       public         postgres    false    6                       1259    27453    situacaoordem    TABLE s   CREATE TABLE situacaoordem (
    idsituacaoordem integer NOT NULL,
    descricao character varying(50) NOT NULL
);
 !   DROP TABLE public.situacaoordem;
       public         postgres    false    6            �           1259    27880    situacaopedido    TABLE u   CREATE TABLE situacaopedido (
    idsituacaopedido integer NOT NULL,
    descricao character varying(50) NOT NULL
);
 "   DROP TABLE public.situacaopedido;
       public         postgres    false    6            ~           1247    27458 
   targetinfo    TYPE �   CREATE TYPE targetinfo AS (
	target oid,
	schema oid,
	nargs integer,
	argtypes oidvector,
	targetname name,
	argmodes "char"[],
	argnames text[],
	targetlang oid,
	fqname text,
	returnsset boolean,
	returntype oid
);
    DROP TYPE public.targetinfo;
       public       postgres    false    6    1664            �           1259    27459    tela    TABLE �   CREATE TABLE tela (
    idtela integer NOT NULL,
    titulotela character varying(50),
    nometela character varying(50) NOT NULL,
    titulomenu character varying(50)
);
    DROP TABLE public.tela;
       public         postgres    false    6            �           1259    27462 	   telabotao    TABLE x   CREATE TABLE telabotao (
    idtelabotao integer NOT NULL,
    idtela integer NOT NULL,
    idbotao integer NOT NULL
);
    DROP TABLE public.telabotao;
       public         postgres    false    6            �           1259    27465    telefone    TABLE �   CREATE TABLE telefone (
    idtelefone integer NOT NULL,
    ddd character varying(3) NOT NULL,
    telefone character varying(14) NOT NULL,
    idfornecedor integer NOT NULL,
    idtipotelefone integer NOT NULL
);
    DROP TABLE public.telefone;
       public         postgres    false    6            �           1259    27468    tipofornecedor    TABLE u   CREATE TABLE tipofornecedor (
    idtipofornecedor integer NOT NULL,
    descricao character varying(50) NOT NULL
);
 "   DROP TABLE public.tipofornecedor;
       public         postgres    false    6            �           1259    27471    tipotelefone    TABLE q   CREATE TABLE tipotelefone (
    idtipotelefone integer NOT NULL,
    descricao character varying(50) NOT NULL
);
     DROP TABLE public.tipotelefone;
       public         postgres    false    6            �           1259    27474    ultimousuario    TABLE q   CREATE TABLE ultimousuario (
    usuario character varying(15) NOT NULL,
    idultimousuario integer NOT NULL
);
 !   DROP TABLE public.ultimousuario;
       public         postgres    false    6            �           1259    27477    unidademedida    TABLE �   CREATE TABLE unidademedida (
    idunidademedida integer NOT NULL,
    nome character varying(100) NOT NULL,
    miligrama boolean,
    grama boolean,
    quilograma boolean
);
 !   DROP TABLE public.unidademedida;
       public         postgres    false    6            �           1259    27480    usuario    TABLE �   CREATE TABLE usuario (
    idusuario integer NOT NULL,
    idcargo integer NOT NULL,
    idperfil integer NOT NULL,
    nomeusuario character varying(100) NOT NULL,
    senha character varying(30) NOT NULL,
    login character varying(30) NOT NULL
);
    DROP TABLE public.usuario;
       public         postgres    false    6            �           1247    27485    var    TYPE �   CREATE TYPE var AS (
	name text,
	varclass character(1),
	linenumber integer,
	isunique boolean,
	isconst boolean,
	isnotnull boolean,
	dtype oid,
	value text
);
    DROP TYPE public.var;
       public       postgres    false    6    1673                        1255    27486    Gravar_Log()    FUNCTION �I  CREATE FUNCTION "Gravar_Log"() RETURNS trigger
    AS $$/*DECLARE
 -- Retorno da fun��o
 liAux integer;
 -- Auditoria de deletes, (0) desativa
 liDelete integer = 1;
 -- Auditoria de inserts, (0) desativa
 liInsert integer = 1;
 -- Auditoria de updates, (0) desativa
 liUpdate integer = 1;
 -- Nome da tabela auditada
 lsTabela text = 'tabela_teste';
 -- Schema onde os dados ser�o auditados
 SchemaOrigem text = 'public';
 
BEGIN
 SELECT
   count (*)
 FROM
   pg_catalog.pg_language
 INTO liaux
 WHERE
   lanname = 'plpgsql';
 
 -- Verificando se a linguagem foi definida
 IF liAux = 0 THEN
   RAISE EXCEPTION 'PLPGSQL n�o foi definido';
 END IF;
 
 SELECT
   count (*)
 FROM
   pg_catalog.pg_tables
 INTO liaux
 WHERE
   tablename = 'auditoria01';

2� parte:

 -- Veriricando se a tabela de auditoria existe
 IF liAux = 0 THEN
   RAISE EXCEPTION
     'A tabela de auditoria n�o foi definida.';
 END IF;
 
 -- Verifica se a tabela a ser auditada existe
 IF SchemaOrigem IS NULL THEN
   SELECT
     count (*)
   FROM
     pg_tables
   INTO liaux
   WHERE
     tablename = lstabela;
 ELSE
   SELECT
     count (*)
   FROM
     pg_tables
   INTO liaux
   WHERE
     schemaorigem = schemaorigem AND
     tablename = lstabela;
 END IF;
 
 IF liAux = 0 THEN
   RAISE EXCEPTION 'A tabela % n�o exite.',
     SchemaOrigem || lsTabela;
 END IF;*/

 /*         IF (TG_OP = 'DELETE') THEN
            INSERT INTO emp_audit SELECT 'D', now(), user, OLD.*;
            RETURN OLD;
        ELSIF (TG_OP = 'UPDATE') THEN
            INSERT INTO emp_audit SELECT 'U', now(), user, NEW.*;
            RETURN NEW;
        ELSIF (TG_OP = 'INSERT') THEN
            INSERT INTO emp_audit SELECT 'I', now(), user, NEW.*;
            RETURN NEW;
        END IF;
        RETURN NULL; -- result is ignored since this is an AFTER trigger
    END;
*/
/*******************************************************************************************************
* TRIGGER QUE TEM A FUN��O DE REGISTRAR NA TABELA AUDITORIA TODA OPERA��O DE INSERT/UPDATE/DELETE EM 
* TODAS AS TABELAS DO BANCO.
*
*******************************************************************************************************/
 DECLARE 
 TextoDados character varying(5000);
 idRef integer;
 logusuario character varying(30);
 
BEGIN
select usuario from ultimousuario into logusuario;
TextoDados := '|';
-------------------------- INFORMA��ES TABELA CARGO -----------------------------------------------------
  IF (TG_TABLE_NAME = 'cargo') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idcargo;
      TextoDados := TextoDados || 'descricao = '|| NEW.descricao || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idcargo;
      TextoDados := TextoDados || 'descricao = '|| OLD.descricao || '|';
    END IF;
  IF (TG_OP = 'DELETE') THEN
    INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN OLD;
 ELSIF (TG_OP = 'UPDATE') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
 ELSIF (TG_OP = 'INSERT') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
  END IF;
 END IF;
 
 ----------------------------------     INFORMA��ES TABELA BANCO ----------------------------------------
   IF (TG_TABLE_NAME = 'banco') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idbanco;
      TextoDados := TextoDados || 'nome = '|| NEW.nome || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idbanco;
      TextoDados := TextoDados || 'nome = '|| OLD.nome || '|';
    END IF;
  IF (TG_OP = 'DELETE') THEN
    INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN OLD;
 ELSIF (TG_OP = 'UPDATE') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
 ELSIF (TG_OP = 'INSERT') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
  END IF;
 END IF;
 
 ----------------------------------     INFORMA��ES TABELA BOTAO ----------------------------------------
   IF (TG_TABLE_NAME = 'botao') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idbotao;
      TextoDados := TextoDados || 'titulobotao = '|| NEW.titulobotao || '|';   
      TextoDados := TextoDados || 'nomebotao = '|| NEW.nomebotao || '|';   
      TextoDados := TextoDados || 'descricaobotao = '|| NEW.descricaobotao || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idbotao;
      TextoDados := TextoDados || 'titulobotao = '|| OLD.titulobotao || '|';   
      TextoDados := TextoDados || 'nomebotao = '|| OLD.nomebotao || '|';   
      TextoDados := TextoDados || 'descricaobotao = '|| OLD.descricaobotao || '|';      
    END IF;
  IF (TG_OP = 'DELETE') THEN
    INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN OLD;
 ELSIF (TG_OP = 'UPDATE') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
 ELSIF (TG_OP = 'INSERT') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
  END IF;
 END IF;

 ----------------------------------     INFORMA��ES TABELA FORMA DE PAGAMENTO ----------------------------------------
   IF (TG_TABLE_NAME = 'formapagamento') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idformapagamento;
      TextoDados := TextoDados || 'nome = '|| NEW.nome || '|';   
      TextoDados := TextoDados || 'operacaobancaria = '|| NEW.operacaobancaria || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idformapagamento;
      TextoDados := TextoDados || 'nome = '|| OLD.nome || '|';   
      TextoDados := TextoDados || 'operacaobancaria = '|| OLD.operacaobancaria || '|';       
    END IF;
  IF (TG_OP = 'DELETE') THEN
    INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN OLD;
 ELSIF (TG_OP = 'UPDATE') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
 ELSIF (TG_OP = 'INSERT') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
  END IF;
 END IF;

 ----------------------------------     INFORMA��ES TABELA MOTIVO ----------------------------------------
   IF (TG_TABLE_NAME = 'motivo') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idmotivo;
      TextoDados := TextoDados || 'nome = '|| NEW.nome || '|';   
      TextoDados := TextoDados || 'baixar = '|| NEW.baixar || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idmotivo;
      TextoDados := TextoDados || 'nome = '|| OLD.nome || '|';   
      TextoDados := TextoDados || 'baixar = '|| OLD.baixar || '|';       
    END IF;
  IF (TG_OP = 'DELETE') THEN
    INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN OLD;
 ELSIF (TG_OP = 'UPDATE') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
 ELSIF (TG_OP = 'INSERT') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
  END IF;
 END IF;

 ----------------------------------     INFORMA��ES TABELA PERFIL ----------------------------------------
   IF (TG_TABLE_NAME = 'perfil') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idperfil;
      TextoDados := TextoDados || 'nome = '|| NEW.nome || '|';   
      TextoDados := TextoDados || 'baixar = '|| NEW.administrador || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idperfil;
      TextoDados := TextoDados || 'nome = '|| OLD.nome || '|';   
      TextoDados := TextoDados || 'baixar = '|| OLD.administrador || '|';         
    END IF;
  IF (TG_OP = 'DELETE') THEN
    INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN OLD;
 ELSIF (TG_OP = 'UPDATE') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
 ELSIF (TG_OP = 'INSERT') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
  END IF;
 END IF;

 ----------------------------------     INFORMA��ES TABELA PERFIL TELA ----------------------------------------
   IF (TG_TABLE_NAME = 'perfiltela') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idperfiltela;
      TextoDados := TextoDados || 'idperfil = '|| NEW.idperfil || '|';   
      TextoDados := TextoDados || 'idtela = '|| NEW.idtela || '|';      
      TextoDados := TextoDados || 'idbotao = '|| NEW.idbotao || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idperfiltela;
      TextoDados := TextoDados || 'idperfil = '|| OLD.idperfil || '|';   
      TextoDados := TextoDados || 'idtela = '|| OLD.idtela || '|';      
      TextoDados := TextoDados || 'idbotao = '|| OLD.idbotao || '|';         
    END IF;
  IF (TG_OP = 'DELETE') THEN
    INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN OLD;
 ELSIF (TG_OP = 'UPDATE') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
 ELSIF (TG_OP = 'INSERT') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
  END IF;
 END IF;

 ----------------------------------     INFORMA��ES TABELA TELA ----------------------------------------
   IF (TG_TABLE_NAME = 'tela') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idtela;
      TextoDados := TextoDados || 'titulotela = '|| NEW.titulotela || '|';   
      TextoDados := TextoDados || 'nometela = '|| NEW.nometela || '|';      
      TextoDados := TextoDados || 'titulomenu = '|| NEW.titulomenu || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idtela;
      TextoDados := TextoDados || 'titulotela = '|| OLD.titulotela || '|';   
      TextoDados := TextoDados || 'nometela = '|| OLD.nometela || '|';      
      TextoDados := TextoDados || 'titulomenu = '|| OLD.titulomenu || '|';           
    END IF;
  IF (TG_OP = 'DELETE') THEN
    INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN OLD;
 ELSIF (TG_OP = 'UPDATE') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
 ELSIF (TG_OP = 'INSERT') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
  END IF;
 END IF;

----------------------------------     INFORMA��ES TABELA TELABOTAO ----------------------------------------
   IF (TG_TABLE_NAME = 'telabotao') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idtelabotao;
      TextoDados := TextoDados || 'idtela = '|| NEW.idtela || '|';   
      TextoDados := TextoDados || 'idbotao = '|| NEW.idbotao || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idtelabotao;
      TextoDados := TextoDados || 'idtela = '|| OLD.idtela || '|';   
      TextoDados := TextoDados || 'idbotao = '|| OLD.idbotao || '|';          
    END IF;
  IF (TG_OP = 'DELETE') THEN
    INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN OLD;
 ELSIF (TG_OP = 'UPDATE') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
 ELSIF (TG_OP = 'INSERT') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
  END IF;
 END IF;

----------------------------------     INFORMA��ES TABELA UNIDADE DE MEDIDA ----------------------------------------
   IF (TG_TABLE_NAME = 'unidademedida') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idunidademedida;
      TextoDados := TextoDados || 'nome = '|| NEW.nome || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idunidademedida;
      TextoDados := TextoDados || 'nome = '|| OLD.nome || '|';         
    END IF;
  IF (TG_OP = 'DELETE') THEN
    INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN OLD;
 ELSIF (TG_OP = 'UPDATE') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
 ELSIF (TG_OP = 'INSERT') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
  END IF;
 END IF;

----------------------------------     INFORMA��ES TABELA USU�RIO ----------------------------------------
   IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idcargo = '|| NEW.idcargo || '|';      
      TextoDados := TextoDados || 'idperfil = '|| NEW.idperfil || '|';      
      TextoDados := TextoDados || 'nomeusuario = '|| NEW.nomeusuario || '|';      
      TextoDados := TextoDados || 'login = '|| NEW.login || '|';      
      TextoDados := TextoDados || 'senha = '|| NEW.senha || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idcargo = '|| OLD.idcargo || '|';      
      TextoDados := TextoDados || 'idperfil = '|| OLD.idperfil || '|';      
      TextoDados := TextoDados || 'nomeusuario = '|| OLD.nomeusuario || '|';      
      TextoDados := TextoDados || 'login = '|| OLD.login || '|';      
      TextoDados := TextoDados || 'senha = '|| OLD.senha || '|';       
    END IF;
  IF (TG_OP = 'DELETE') THEN
    INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN OLD;
 ELSIF (TG_OP = 'UPDATE') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
 ELSIF (TG_OP = 'INSERT') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
  END IF;
 END IF;
 RETURN NULL;
 END;$$
    LANGUAGE plpgsql;
 %   DROP FUNCTION public."Gravar_Log"();
       public       postgres    false    6    458                        1255    27488 5   gravarsaldo(date, integer, numeric, integer, integer)    FUNCTION �B  CREATE FUNCTION gravarsaldo(datasaldo date, produto integer, valor numeric, tiposaldo integer, operacao integer, OUT gravousaldo boolean) RETURNS boolean
    AS $$/**********************************************************************************************************
* Objetivo : gravar o saldo nas tabelas de controle do saldo.
*  	     TipoSaldo = 0 - saldoentrada
*	     TipoSaldo = 1 - saldosaida
*	     TipoSaldo = 2 - saldocomprometido
*	     TipoSaldo = 3 - saldopendente
*
*	     O parametro tipo de entrada ser� utilizado apenas nos casos que envolvam saldo comprometido e saldo 
*            pendente.	     
*            operacao = 0 - Entrada
*            operacao = 1 - Saida
* OBS : Quando a aplica��o for alterar um movimento � necessario retirar da entrada ou saida, codigos esses
*       implementado apenas na parte referente a altera��o
**********************************************************************************************************/
DECLARE 
AnoD INTEGER;
MesD INTEGER;
DiaD INTEGER;
Contador INTEGER;
IdEncontrado Integer;
SaldoAntigo NUMERIC(12,3);
Saldo NUMERIC(12,3);
BEGIN
  AnoD := date_part('year', datasaldo);
  MesD := date_part('month', datasaldo);
  DiaD := date_part('day', datasaldo);   
  IdEncontrado := 0;
  SaldoAntigo := 0;
  Saldo := 0;
  SELECT Count(*) FROM saldoano sa INTO Contador WHERE sa.idproduto = produto AND sa.ano = AnoD;
  -- se n�o existe o ano para o produto j� gravado
  IF Contador = 0 THEN
      -- se for pra gravar um saldo de entrada
      IF (tiposaldo = 0) THEN
          INSERT INTO saldoano ( ano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto)
                      values   ( AnoD,valor, 0,0,0, produto);
        ELSIF (tiposaldo = 1) THEN 
        -- se for pra gravar um saldo de saida
        
          INSERT INTO saldoano (ano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto)
                      values   (AnoD,0,valor,0,0, produto);
	-- se for p gravar um saldo comprometido
        ELSIF (tiposaldo = 2) THEN       
          -- se for pra somar
          IF (operacao = 0) THEN
              INSERT INTO saldoano (ano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto)
                          values   (AnoD, 0,0,valor,0, produto);
          ELSE          
            -- se for para diminuir
              INSERT INTO saldoano (ano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto)
                          values   (AnoD, 0,0,valor ,0, produto);
          END IF;
	-- se for para gravar um saldo pendente
        ELSE        
          -- se for pra somar
          IF (operacao = 0) THEN
              INSERT INTO saldoano (ano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto)
                          values   (AnoD, 0,0,0,valor, produto);
            ELSE
            -- se for para diminuir
              INSERT INTO saldoano (ano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto)
                          values   (AnoD, 0,0,0,valor * -1, produto);
          END IF;
        END IF;   
    --EXCEPTION WHEN division_by_zero THEN GRAVOUSALDO := FALSE;
    --END IF;
    SELECT currval('saldoano_idano_seq') INTO IdEncontrado;     
/**********************************************************************************************************
*					ALTERAR O VALOR DO ANO
**********************************************************************************************************/
  ELSIF (Contador = 1) THEN
      SELECT idsaldoano from saldoano sa into idEncontrado where sa.idproduto = produto AND sa.ano = AnoD;
    --atualizar saldo entrada
    IF (tiposaldo = 0) THEN
        SELECT saldoentrada 
        FROM saldoano 
        INTO SaldoAntigo 
        WHERE idproduto = produto 
	      and ano = AnoD;	
	IF (operacao = 0) THEN	        
           UPDATE saldoano SET saldoentrada = SaldoAntigo + Valor WHERE idsaldoano = IdEncontrado;
        ELSE
            -- se for para diminuir
           UPDATE saldoano SET saldoentrada = SaldoAntigo - Valor WHERE idsaldoano = IdEncontrado;
        END IF;	       
    -- se for pra ATUALIZAR um saldo de saida        
    ELSIF (tiposaldo = 1) THEN
            SELECT saldosaida
            FROM saldoano 
            INTO SaldoAntigo 
            WHERE idproduto = produto 
	          and ano = AnoD; 
            IF (operacao = 0) THEN	        
                UPDATE saldoano SET saldosaida = SaldoAntigo + Valor WHERE idsaldoano = IdEncontrado;
            ELSE
            -- se for para diminuir
                UPDATE saldoano SET saldosaida = SaldoAntigo - Valor WHERE idsaldoano = IdEncontrado;
            END IF;	           
	 -- se for p atualizar um saldo comprometido            
     ELSIF (tiposaldo = 2) THEN
          -- se for pra somar
	    SELECT saldocomprometido
            FROM saldoano 
            INTO SaldoAntigo 
            WHERE idproduto = produto 
	          and ano = AnoD;
            IF (operacao = 0) THEN	        
                UPDATE saldoano SET saldocomprometido = SaldoAntigo + Valor WHERE idsaldoano = IdEncontrado;
            ELSE
            -- se for para diminuir
                UPDATE saldoano SET saldocomprometido = SaldoAntigo - Valor WHERE idsaldoano = IdEncontrado;
            END IF;
	-- se for para gravar um saldo pendente                
        ELSE 
	    SELECT saldopendente
            FROM saldoano 
            INTO SaldoAntigo 
            WHERE idproduto = produto 
	          and ano = AnoD;
          -- se for pra somar
          IF (operacao = 0) THEN
              UPDATE saldoano SET saldopendente = SaldoAntigo + Valor WHERE idsaldoano = IdEncontrado;
            ELSE
            -- se for para diminuir
                UPDATE saldoano SET saldopendente = SaldoAntigo - Valor WHERE idsaldoano = IdEncontrado;
            END IF;
        END IF;
    --EXCEPTION WHEN division_by_zero THEN GRAVOUSALDO := FALSE;
    ELSE
    GRAVOUSALDO := FALSE;
  -- elaborar ROTINA PARA SAIR DA FUN��O
      --ELABORAR ROTINA PARA SAIR DA FUN��O;
    END IF;
GRAVOUSALDO := TRUE;    
/********************************************************************************************************
*				CALCULO PARA O MES
*********************************************************************************************************/ 
  SELECT Count(*) 
  FROM saldomes sm 
       INNER JOIN saldoano sa ON sm.idsaldoano = sa.idsaldoano 
  INTO Contador 
  WHERE sm.idproduto = produto AND sm.mes = mesD AND sa.ano = AnoD;
  -- se n�o existe o mes para o produto j� gravado
  IF Contador = 0 THEN
      -- se for pra gravar um saldo de entrada
      IF (tiposaldo = 0) THEN
          INSERT INTO saldomes (mes, idsaldoano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto)
                      values   (mesD, IdEncontrado, valor, 0,0,0, produto);
	-- se for pra gravar um saldo de saida
        ELSIF (tiposaldo = 1) THEN 
          INSERT INTO saldomes (mes, idsaldoano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto)
                      values   (mesD, IdEncontrado, 0,valor,0,0, produto);
	-- se for p gravar um saldo comprometido
        ELSIF (tiposaldo = 2) THEN
          -- se for pra somar
          IF (operacao = 0) THEN
              INSERT INTO saldomes (mes, idsaldoano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto)
                          values   (mesD, idEncontrado, 0,0,valor,0, produto);
            ELSE
            -- se for para diminuir
              INSERT INTO saldomes (mes, idsaldoano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto)
                          values   (mesD, idEncontrado, 0,0,valor ,0, produto);
          END IF;
	-- se for para gravar um saldo pendente
        ELSE        
        -- se for pra somar
          IF (operacao = 0) THEN
              INSERT INTO saldomes (mes, idsaldoano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto)
                          values   (mesD,idEncontrado, 0,0,0,valor, produto);
	    -- se for para diminuir
          ELSE             
              INSERT INTO saldomes (mes, idsaldoano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto)
                          values   (mesD, idEncontrado, 0,0,0,valor * -1, produto);
          END IF;
        END IF;
    --EXCEPTION WHEN division_by_zero THEN GRAVOUSALDO := FALSE;
    SELECT currval('saldomes_idsaldomes_seq') INTO IdEncontrado;   
/**********************************************************************************************************
*					ALTERAR O VALOR DO Mes
**********************************************************************************************************/  
   ELSIF (Contador = 1) THEN
      SELECT idsaldomes  
      FROM saldomes sm 
           INNER JOIN saldoano sa ON sm.idsaldoano = sa.idsaldoano  
      INTO idEncontrado where sm.idproduto = produto AND sm.mes = mesD AND sa.ano = AnoD;
    --atualizar saldo entrada
    IF (tiposaldo = 0) THEN
        SELECT saldoentrada 
        FROM saldomes
        INTO SaldoAntigo 
        WHERE idproduto = produto 
	      and mes = mesD;
            IF (operacao = 0) THEN	        
                UPDATE saldomes SET saldoentrada = SaldoAntigo + Valor WHERE idsaldomes = IdEncontrado;
            ELSE
            -- se for para diminuir
                UPDATE saldomes SET saldoentrada = SaldoAntigo - Valor WHERE idsaldomes = IdEncontrado;
            END IF;	          
    -- se for pra ATUALIZAR um saldo de saida        
    ELSIF (tiposaldo = 1) THEN
            SELECT saldosaida
        FROM saldomes
        INTO SaldoAntigo 
        WHERE idproduto = produto 
	      and mes = mesD;
            IF (operacao = 0) THEN	        
                UPDATE saldomes SET saldosaida = SaldoAntigo + Valor WHERE idsaldomes = IdEncontrado;
            ELSE
            -- se for para diminuir
               UPDATE saldomes SET saldosaida = SaldoAntigo - Valor WHERE idsaldomes = IdEncontrado;
            END IF;	                      
	 -- se for p atualizar um saldo comprometido            
         ELSIF (tiposaldo = 2) THEN
          -- se for pra somar
	    SELECT saldocomprometido
        FROM saldomes
        INTO SaldoAntigo 
        WHERE idproduto = produto 
	      and mes = mesD;
            IF (operacao = 0) THEN	        
                UPDATE saldomes SET saldocomprometido = SaldoAntigo + Valor WHERE idsaldomes = IdEncontrado;
            ELSE
            -- se for para diminuir
                UPDATE saldomes SET saldocomprometido = SaldoAntigo - Valor WHERE idsaldomes = IdEncontrado;
            END IF;
	-- se for para gravar um saldo pendente                
        ELSE 
	    SELECT saldopendente
            FROM saldomes
            INTO SaldoAntigo 
            WHERE idproduto = produto 
	          and mes = mesD;
          -- se for pra somar
          IF (operacao = 0) THEN
              UPDATE saldomes SET saldopendente = SaldoAntigo + Valor WHERE idsaldomes = IdEncontrado;
            ELSE
            -- se for para diminuir
              UPDATE saldomes SET saldopendente = SaldoAntigo - Valor WHERE idsaldomes = IdEncontrado;
          END IF;
        END IF;
    --EXCEPTION WHEN division_by_zero THEN GRAVOUSALDO := FALSE;
    ELSE
  END IF;
/**********************************************************************************************************
*					Calcular o valor do dia
**********************************************************************************************************/
  SELECT Count(*) FROM saldodia sd INTO Contador WHERE sd.idproduto = produto AND sd.datasaldodia = datasaldo;
  -- se n�o existe o dia para o produto j� gravado
  IF Contador = 0 THEN
      -- se for pra gravar um saldo de entrada
      IF (tiposaldo = 0) THEN
          INSERT INTO saldodia (datasaldodia, saldoentrada, saldosaida, saldocomprometido, saldopendente, idsaldomes,idproduto)
                      values   (datasaldo, valor, 0,0,0, IdEncontrado, produto);
	-- se for pra gravar um saldo de saida
        ELSIF (tiposaldo = 1) THEN 
          INSERT INTO saldodia (datasaldodia, saldoentrada, saldosaida, saldocomprometido, saldopendente, idsaldomes,idproduto)
                      values   (datasaldo, 0,valor,0,0, IdEncontrado, produto);
	-- se for p gravar um saldo comprometido
        ELSIF (tiposaldo = 2) THEN
          -- se for pra somar
          IF (operacao = 0) THEN
              INSERT INTO saldodia (datasaldodia, saldoentrada, saldosaida, saldocomprometido, saldopendente, idsaldomes,idproduto)
                      values   (datasaldo, 0,0,valor,0, IdEncontrado, produto);
            ELSE 
            -- se for para diminuir
              INSERT INTO saldodia (datasaldodia, saldoentrada, saldosaida, saldocomprometido, saldopendente, idsaldomes,idproduto)
                      values   (datasaldo, 0,0,valor * -1,0, IdEncontrado, produto);
          END IF;
	-- se for para gravar um saldo pendente
        ELSE
          -- se for pra somar
          IF (operacao = 0) THEN
              INSERT INTO saldodia (datasaldodia, saldoentrada, saldosaida, saldocomprometido, saldopendente, idsaldomes,idproduto)
                      values   (datasaldo, 0,0,0,valor, IdEncontrado, produto);
            ELSE
            -- se for para diminuir
              INSERT INTO saldodia (datasaldodia, saldoentrada, saldosaida, saldocomprometido, saldopendente, idsaldomes,idproduto)
                      values   (datasaldo, 0,0,0,valor * -1, IdEncontrado, produto);
            END IF;
        END IF;
    --EXCEPTION WHEN division_by_zero THEN GRAVOUSALDO := FALSE;
/**********************************************************************************************************
*					Alterar o valor do dia
**********************************************************************************************************/
  ELSIF (Contador = 1) THEN
      SELECT idsaldodia from saldodia sd into idEncontrado where sd.idproduto = produto AND sd.datasaldodia = datasaldo;
    --atualizar saldo entrada
    IF (tiposaldo = 0) THEN
        SELECT saldoentrada 
        FROM saldodia
        INTO SaldoAntigo 
        WHERE idproduto = produto 
	      and datasaldodia = datasaldo;
            IF (operacao = 0) THEN	        
                UPDATE saldodia SET saldoentrada = SaldoAntigo + Valor WHERE idsaldodia = IdEncontrado;
            ELSE
            -- se for para diminuir
                UPDATE saldodia SET saldoentrada = SaldoAntigo - Valor WHERE idsaldodia = IdEncontrado;
	-- se for para gravar um saldo pendente 
           END IF;  	              
    -- se for pra ATUALIZAR um saldo de saida        
    ELSIF (tiposaldo = 1) THEN
            SELECT saldosaida
        FROM saldodia
        INTO SaldoAntigo 
        WHERE idproduto = produto 
	      and datasaldodia = datasaldo;
            IF (operacao = 0) THEN	        
                UPDATE saldodia SET saldosaida = SaldoAntigo + Valor WHERE idsaldodia = IdEncontrado;
            ELSE
            -- se for para diminuir
                UPDATE saldodia SET saldosaida = SaldoAntigo - Valor WHERE idsaldodia = IdEncontrado;
	-- se for para gravar um saldo pendente 
           END IF;  	                      
	 -- se for p atualizar um saldo comprometido            
    ELSIF (tiposaldo = 2) THEN
          -- se for pra somar
	SELECT saldocomprometido
        FROM saldodia
        INTO SaldoAntigo 
        WHERE idproduto = produto 
	      and datasaldodia = datasaldo;
            IF (operacao = 0) THEN	        
                UPDATE saldodia SET saldocomprometido = SaldoAntigo + Valor WHERE idsaldodia = IdEncontrado;
            ELSE
            -- se for para diminuir
                UPDATE saldodia SET saldocomprometido = SaldoAntigo - Valor WHERE idsaldodia = IdEncontrado;
	-- se for para gravar um saldo pendente 
           END IF;               
    ELSE
	SELECT saldopendente
        FROM saldodia
        INTO SaldoAntigo 
        WHERE idproduto = produto 
	      and datasaldodia = datasaldo;
          -- se for pra somar
          IF (operacao = 0) THEN
              UPDATE saldodia SET saldopendente = SaldoAntigo + Valor WHERE idsaldodia = IdEncontrado;
          ELSE 
            -- se for para diminuir
              UPDATE saldodia SET saldopendente = SaldoAntigo - Valor WHERE idsaldodia = IdEncontrado;
          END IF;
    END IF;
    --EXCEPTION WHEN division_by_zero THEN GRAVOUSALDO := FALSE;
  ELSE
  END IF;
  /*-- elaborar ROTINA PARA SAIR DA FUN��O
  ELSIF (Contador > 1) THEN
      --ELABORAR ROTINA PARA SAIR DA FUN��O;
      END IF;
  END IF;*/
END;$$
    LANGUAGE plpgsql;
 �   DROP FUNCTION public.gravarsaldo(datasaldo date, produto integer, valor numeric, tiposaldo integer, operacao integer, OUT gravousaldo boolean);
       public       postgres    false    458    6                        1255    27490    pldbg_abort_target(integer)    FUNCTION �   CREATE FUNCTION pldbg_abort_target(session integer) RETURNS SETOF boolean
    AS '$libdir/pldbgapi', 'pldbg_abort_target'
    LANGUAGE c STRICT;
 :   DROP FUNCTION public.pldbg_abort_target(session integer);
       public       postgres    false    6                        1255    27491    pldbg_attach_to_port(integer)    FUNCTION �   CREATE FUNCTION pldbg_attach_to_port(portnumber integer) RETURNS integer
    AS '$libdir/pldbgapi', 'pldbg_attach_to_port'
    LANGUAGE c STRICT;
 ?   DROP FUNCTION public.pldbg_attach_to_port(portnumber integer);
       public       postgres    false    6                        1255    27492    pldbg_continue(integer)    FUNCTION �   CREATE FUNCTION pldbg_continue(session integer) RETURNS breakpoint
    AS '$libdir/pldbgapi', 'pldbg_continue'
    LANGUAGE c STRICT;
 6   DROP FUNCTION public.pldbg_continue(session integer);
       public       postgres    false    320    6                        1255    27493    pldbg_create_listener()    FUNCTION �   CREATE FUNCTION pldbg_create_listener() RETURNS integer
    AS '$libdir/pldbgapi', 'pldbg_create_listener'
    LANGUAGE c STRICT;
 .   DROP FUNCTION public.pldbg_create_listener();
       public       postgres    false    6                        1255    27494 1   pldbg_deposit_value(integer, text, integer, text)    FUNCTION �   CREATE FUNCTION pldbg_deposit_value(session integer, varname text, linenumber integer, value text) RETURNS boolean
    AS '$libdir/pldbgapi', 'pldbg_deposit_value'
    LANGUAGE c STRICT;
 i   DROP FUNCTION public.pldbg_deposit_value(session integer, varname text, linenumber integer, value text);
       public       postgres    false    6                        1255    27495 ,   pldbg_drop_breakpoint(integer, oid, integer)    FUNCTION �   CREATE FUNCTION pldbg_drop_breakpoint(session integer, func oid, linenumber integer) RETURNS boolean
    AS '$libdir/pldbgapi', 'pldbg_drop_breakpoint'
    LANGUAGE c STRICT;
 [   DROP FUNCTION public.pldbg_drop_breakpoint(session integer, func oid, linenumber integer);
       public       postgres    false    6                        1255    27496    pldbg_get_breakpoints(integer)    FUNCTION �   CREATE FUNCTION pldbg_get_breakpoints(session integer) RETURNS SETOF breakpoint
    AS '$libdir/pldbgapi', 'pldbg_get_breakpoints'
    LANGUAGE c STRICT;
 =   DROP FUNCTION public.pldbg_get_breakpoints(session integer);
       public       postgres    false    6    320                        1255    27497    pldbg_get_proxy_info()    FUNCTION �   CREATE FUNCTION pldbg_get_proxy_info() RETURNS proxyinfo
    AS '$libdir/pldbgapi', 'pldbg_get_proxy_info'
    LANGUAGE c STRICT;
 -   DROP FUNCTION public.pldbg_get_proxy_info();
       public       postgres    false    6    370                        1255    27498    pldbg_get_source(integer, oid)    FUNCTION �   CREATE FUNCTION pldbg_get_source(session integer, func oid) RETURNS text
    AS '$libdir/pldbgapi', 'pldbg_get_source'
    LANGUAGE c STRICT;
 B   DROP FUNCTION public.pldbg_get_source(session integer, func oid);
       public       postgres    false    6                        1255    27499    pldbg_get_stack(integer)    FUNCTION �   CREATE FUNCTION pldbg_get_stack(session integer) RETURNS SETOF frame
    AS '$libdir/pldbgapi', 'pldbg_get_stack'
    LANGUAGE c STRICT;
 7   DROP FUNCTION public.pldbg_get_stack(session integer);
       public       postgres    false    6    346                         1255    27500 #   pldbg_get_target_info(text, "char")    FUNCTION �   CREATE FUNCTION pldbg_get_target_info(signature text, targettype "char") RETURNS targetinfo
    AS '$libdir/targetinfo', 'pldbg_get_target_info'
    LANGUAGE c STRICT;
 O   DROP FUNCTION public.pldbg_get_target_info(signature text, targettype "char");
       public       postgres    false    6    382            !            1255    27501    pldbg_get_variables(integer)    FUNCTION �   CREATE FUNCTION pldbg_get_variables(session integer) RETURNS SETOF var
    AS '$libdir/pldbgapi', 'pldbg_get_variables'
    LANGUAGE c STRICT;
 ;   DROP FUNCTION public.pldbg_get_variables(session integer);
       public       postgres    false    400    6            "            1255    27502 $   pldbg_select_frame(integer, integer)    FUNCTION �   CREATE FUNCTION pldbg_select_frame(session integer, frame integer) RETURNS breakpoint
    AS '$libdir/pldbgapi', 'pldbg_select_frame'
    LANGUAGE c STRICT;
 I   DROP FUNCTION public.pldbg_select_frame(session integer, frame integer);
       public       postgres    false    6    320            #            1255    27503 +   pldbg_set_breakpoint(integer, oid, integer)    FUNCTION �   CREATE FUNCTION pldbg_set_breakpoint(session integer, func oid, linenumber integer) RETURNS boolean
    AS '$libdir/pldbgapi', 'pldbg_set_breakpoint'
    LANGUAGE c STRICT;
 Z   DROP FUNCTION public.pldbg_set_breakpoint(session integer, func oid, linenumber integer);
       public       postgres    false    6            $            1255    27504 ;   pldbg_set_global_breakpoint(integer, oid, integer, integer)    FUNCTION �   CREATE FUNCTION pldbg_set_global_breakpoint(session integer, func oid, linenumber integer, targetpid integer) RETURNS boolean
    AS '$libdir/pldbgapi', 'pldbg_set_global_breakpoint'
    LANGUAGE c;
 t   DROP FUNCTION public.pldbg_set_global_breakpoint(session integer, func oid, linenumber integer, targetpid integer);
       public       postgres    false    6            %            1255    27505    pldbg_step_into(integer)    FUNCTION �   CREATE FUNCTION pldbg_step_into(session integer) RETURNS breakpoint
    AS '$libdir/pldbgapi', 'pldbg_step_into'
    LANGUAGE c STRICT;
 7   DROP FUNCTION public.pldbg_step_into(session integer);
       public       postgres    false    6    320            &            1255    27506    pldbg_step_over(integer)    FUNCTION �   CREATE FUNCTION pldbg_step_over(session integer) RETURNS breakpoint
    AS '$libdir/pldbgapi', 'pldbg_step_over'
    LANGUAGE c STRICT;
 7   DROP FUNCTION public.pldbg_step_over(session integer);
       public       postgres    false    6    320            '            1255    27507 "   pldbg_wait_for_breakpoint(integer)    FUNCTION �   CREATE FUNCTION pldbg_wait_for_breakpoint(session integer) RETURNS breakpoint
    AS '$libdir/pldbgapi', 'pldbg_wait_for_breakpoint'
    LANGUAGE c STRICT;
 A   DROP FUNCTION public.pldbg_wait_for_breakpoint(session integer);
       public       postgres    false    6    320            (            1255    27508    pldbg_wait_for_target(integer)    FUNCTION �   CREATE FUNCTION pldbg_wait_for_target(session integer) RETURNS integer
    AS '$libdir/pldbgapi', 'pldbg_wait_for_target'
    LANGUAGE c STRICT;
 =   DROP FUNCTION public.pldbg_wait_for_target(session integer);
       public       postgres    false    6            )            1255    27509    plpgsql_oid_debug(oid)    FUNCTION �   CREATE FUNCTION plpgsql_oid_debug(functionoid oid) RETURNS integer
    AS '$libdir/plugins/plugin_debugger', 'plpgsql_oid_debug'
    LANGUAGE c STRICT;
 9   DROP FUNCTION public.plpgsql_oid_debug(functionoid oid);
       public       postgres    false    6            *            1255    27510 %   retornarsaldo(date, integer, integer)    FUNCTION �  CREATE FUNCTION retornarsaldo(datasaldo date, produto integer, tiposaldo integer, OUT saldo numeric) RETURNS numeric
    AS $$/**************************************************************************************************************************
*    Fun��o que tem como objetivo retornar o saldo requesitado na data passada como parametro
*    tiposaldo 0 = saldo entrada;
*              1 = saldo saida;
*              2 = saldo atual;
*              3 = saldo comprometido
*              4 = saldo pendente
*              5 = saldo comprometido real(somado os que est�o registrados para frente da data requerida - os saldos futuros)  
*              6 = saldo real;
**************************************************************************************************************************/

DECLARE	
AnoD INTEGER;
MesD INTEGER;
MesDString Text;
ValorAno NUMERIC(12,3);
ValorMes NUMERIC(12,3);
ValorDia NUMERIC(12,3);
ValorSaida Numeric(12,3);
ValorAtual Numeric(12,3);
ValorEntrada Numeric(12,3);
ValorPendente Numeric(12,3);
DataConcatenada Text;
ValorComprometido Numeric(12,3);
-- Somar� apenas o comprometido para frente da data requerida;
ValorComprometidoReal Numeric(12,3);
BEGIN
    AnoD := date_part('year', datasaldo);
    MesD := date_part('month', datasaldo);
    IF (char_length(CAST(MesD as Text)) = 1) THEN
        MesDString := '0' || CAST(MesD as Text);
    ELSE
        MesDString := CAST(MesD as Text);
    END IF;
    DataConcatenada := CAST(AnoD AS Text) || MesDString || '01'; 
    
    IF (tiposaldo = 0) OR (tiposaldo = 2) OR (tiposaldo = 6)THEN    
        SELECT SUM(sa.saldoentrada)
        FROM saldoano sa INTO ValorAno 
        WHERE sa.ano < AnoD AND sa.idproduto = produto; 
        
        SELECT SUM(sm.saldoentrada) 
        FROM saldomes sm INNER JOIN saldoano sa ON sm.idsaldoano = sa.idsaldoano INTO ValorMes 
        WHERE sa.ano = AnoD AND sm.mes < MesD AND sm.idproduto = produto; 

        SELECT SUM(sd.saldoentrada) 
        FROM saldodia sd INTO ValorDia 
        WHERE sd.datasaldodia between  Cast(DataConcatenada as Date) AND datasaldo 
        AND sd.idproduto = produto;  

        ValorEntrada := VerificaNull(ValorAno, 0.0) + VerificaNull(ValorMes,0.0) + VerificaNull(ValorDia,0.0); 
        saldo := ValorEntrada;
    END IF;                
    IF (tiposaldo = 1) OR (tiposaldo = 2) OR (tiposaldo = 6)THEN
        SELECT SUM(sa.saldosaida)
        FROM saldoano sa INTO ValorAno 
        WHERE sa.ano < AnoD AND sa.idproduto = produto; 
        
        SELECT SUM(sm.saldosaida) 
        FROM saldomes sm INNER JOIN saldoano sa ON sm.idsaldoano = sa.idsaldoano INTO ValorMes 
        WHERE sa.ano = AnoD AND sm.mes < MesD AND sm.idproduto = produto; 

        SELECT SUM(sd.saldosaida) 
        FROM saldodia sd INTO ValorDia 
        WHERE sd.datasaldodia between  Cast(DataConcatenada as Date) AND datasaldo 
        AND sd.idproduto = produto;  

        ValorSaida := VerificaNull(ValorAno, 0.0) + VerificaNull(ValorMes,0.0) + VerificaNull(ValorDia,0.0); 
        saldo := ValorSaida;    
    END IF;
    IF (tiposaldo = 2) OR (tiposaldo = 6) THEN
        ValorAtual := VerificaNull(ValorEntrada, 0.0)  - VerificaNull(ValorSaida, 0.0);
        saldo := ValorAtual;
    END IF;
    IF (tiposaldo = 3) THEN
        SELECT SUM(sa.saldocomprometido) 
        FROM saldoano sa INTO ValorAno 
        WHERE sa.ano < AnoD AND sa.idproduto = produto; 
        
        SELECT SUM(sm.saldocomprometido) 
        FROM saldomes sm INNER JOIN saldoano sa ON sm.idsaldoano = sa.idsaldoano INTO ValorMes 
        WHERE sa.ano = AnoD AND sm.mes < MesD AND sm.idproduto = produto; 

        SELECT SUM(sd.saldocomprometido) 
        FROM saldodia sd INTO ValorDia 
        WHERE sd.datasaldodia between  Cast(DataConcatenada as Date) AND datasaldo 
        AND sd.idproduto = produto;  

        ValorComprometido := VerificaNull(ValorAno, 0.0) + VerificaNull(ValorMes,0.0) + VerificaNull(ValorDia,0.0); 
        saldo := ValorComprometido;
    END IF;    
    IF (tiposaldo = 4) OR (tiposaldo = 6) THEN
        SELECT SUM(sa.saldopendente) 
        FROM saldoano sa INTO ValorAno 
        WHERE sa.ano < AnoD AND sa.idproduto = produto; 
        
        SELECT SUM(sm.saldopendente) 
        FROM saldomes sm INNER JOIN saldoano sa ON sm.idsaldoano = sa.idsaldoano INTO ValorMes 
        WHERE sa.ano = AnoD AND sm.mes < MesD AND sm.idproduto = produto; 

        SELECT SUM(sd.saldopendente) 
        FROM saldodia sd INTO ValorDia 
        WHERE sd.datasaldodia between  Cast(DataConcatenada as Date) AND datasaldo 
        AND sd.idproduto = produto;  

        ValorPendente := VerificaNull(ValorAno, 0.0) + VerificaNull(ValorMes,0.0) + VerificaNull(ValorDia,0.0); 
        saldo := ValorPendente;        
    
    END IF;
     --Se for para retornar o valor real do saldo* --ESTUDAR COMO CAPTURAR O VALOR REAL;
    IF (tiposaldo = 5) OR (tiposaldo = 6) THEN
        SELECT SUM(sa.saldocomprometido) 
        FROM saldoano sa INTO ValorAno 
        WHERE sa.ano < AnoD AND sa.idproduto = produto; 
        
        SELECT SUM(sm.saldocomprometido) 
        FROM saldomes sm INNER JOIN saldoano sa ON sm.idsaldoano = sa.idsaldoano INTO ValorMes 
        WHERE sa.ano = AnoD AND sm.mes < MesD AND sm.idproduto = produto; 

        SELECT SUM(sd.saldocomprometido) 
        FROM saldodia sd INTO ValorDia 
        WHERE sd.datasaldodia >= datasaldo 
        AND sd.idproduto = produto;  

        ValorComprometidoReal := VerificaNull(ValorAno, 0.0) + VerificaNull(ValorMes,0.0) + VerificaNull(ValorDia,0.0); 
        --soma-se o pendente iniciando do primeiro dia do mes;
        saldo := ValorComprometidoReal;        
    END IF;
    IF (tiposaldo = 6) THEN
        ValorComprometidoReal := VerificaNull(ValorAno, 0.0) + VerificaNull(ValorMes,0.0) + VerificaNull(ValorDia,0.0); 
        --soma-se o pendente iniciando do primeiro dia do mes;
        saldo := (ValorAtual + ValorPendente) - ValorComprometidoReal;        
    END IF;    
END;$$
    LANGUAGE plpgsql;
 k   DROP FUNCTION public.retornarsaldo(datasaldo date, produto integer, tiposaldo integer, OUT saldo numeric);
       public       postgres    false    6    458            +            1255    27511    verificanull(numeric, numeric)    FUNCTION �   CREATE FUNCTION verificanull(valor numeric, retornar numeric) RETURNS numeric
    AS $$BEGIN
    IF (valor ISNULL) THEN
	RETURN retornar;
    ELSE
        RETURN valor;
    END IF;
END;$$
    LANGUAGE plpgsql;
 D   DROP FUNCTION public.verificanull(valor numeric, retornar numeric);
       public       postgres    false    6    458            �           1259    27512    Auditoria_idAuditoria_seq    SEQUENCE l   CREATE SEQUENCE "Auditoria_idAuditoria_seq"
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 2   DROP SEQUENCE public."Auditoria_idAuditoria_seq";
       public       postgres    false    6    1630            �           0    0    Auditoria_idAuditoria_seq    SEQUENCE OWNED BY K   ALTER SEQUENCE "Auditoria_idAuditoria_seq" OWNED BY auditoria.idauditoria;
            public       postgres    false    1674            �           0    0    Auditoria_idAuditoria_seq    SEQUENCE SET C   SELECT pg_catalog.setval('"Auditoria_idAuditoria_seq"', 74, true);
            public       postgres    false    1674            �           1259    27514    botao_idbotao_seq    SEQUENCE b   CREATE SEQUENCE botao_idbotao_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 (   DROP SEQUENCE public.botao_idbotao_seq;
       public       postgres    false    1632    6            �           0    0    botao_idbotao_seq    SEQUENCE OWNED BY 9   ALTER SEQUENCE botao_idbotao_seq OWNED BY botao.idbotao;
            public       postgres    false    1675            �           0    0    botao_idbotao_seq    SEQUENCE SET 8   SELECT pg_catalog.setval('botao_idbotao_seq', 6, true);
            public       postgres    false    1675            �           1259    27516    cardapio_idcardapio_seq    SEQUENCE h   CREATE SEQUENCE cardapio_idcardapio_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 .   DROP SEQUENCE public.cardapio_idcardapio_seq;
       public       postgres    false    1634    6            �           0    0    cardapio_idcardapio_seq    SEQUENCE OWNED BY E   ALTER SEQUENCE cardapio_idcardapio_seq OWNED BY cardapio.idcardapio;
            public       postgres    false    1676            �           0    0    cardapio_idcardapio_seq    SEQUENCE SET >   SELECT pg_catalog.setval('cardapio_idcardapio_seq', 1, true);
            public       postgres    false    1676            �           1259    27518    cargo_idcargo_seq    SEQUENCE b   CREATE SEQUENCE cargo_idcargo_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 (   DROP SEQUENCE public.cargo_idcargo_seq;
       public       postgres    false    6    1636            �           0    0    cargo_idcargo_seq    SEQUENCE OWNED BY 9   ALTER SEQUENCE cargo_idcargo_seq OWNED BY cargo.idcargo;
            public       postgres    false    1677            �           0    0    cargo_idcargo_seq    SEQUENCE SET 9   SELECT pg_catalog.setval('cargo_idcargo_seq', 50, true);
            public       postgres    false    1677            �           1259    27520 /   composicaocentesimal_idcomposicaocentesimal_seq    SEQUENCE �   CREATE SEQUENCE composicaocentesimal_idcomposicaocentesimal_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 F   DROP SEQUENCE public.composicaocentesimal_idcomposicaocentesimal_seq;
       public       postgres    false    1637    6            �           0    0 /   composicaocentesimal_idcomposicaocentesimal_seq    SEQUENCE OWNED BY u   ALTER SEQUENCE composicaocentesimal_idcomposicaocentesimal_seq OWNED BY composicaocentesimal.idcomposicaocentesimal;
            public       postgres    false    1678            �           0    0 /   composicaocentesimal_idcomposicaocentesimal_seq    SEQUENCE SET W   SELECT pg_catalog.setval('composicaocentesimal_idcomposicaocentesimal_seq', 21, true);
            public       postgres    false    1678            �           1259    27522 #   dadosbancarios_iddadosbancarios_seq    SEQUENCE t   CREATE SEQUENCE dadosbancarios_iddadosbancarios_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 :   DROP SEQUENCE public.dadosbancarios_iddadosbancarios_seq;
       public       postgres    false    1638    6            �           0    0 #   dadosbancarios_iddadosbancarios_seq    SEQUENCE OWNED BY ]   ALTER SEQUENCE dadosbancarios_iddadosbancarios_seq OWNED BY dadosbancarios.iddadosbancarios;
            public       postgres    false    1679            �           0    0 #   dadosbancarios_iddadosbancarios_seq    SEQUENCE SET K   SELECT pg_catalog.setval('dadosbancarios_iddadosbancarios_seq', 12, true);
            public       postgres    false    1679            �           1259    27524    email_idemail_seq    SEQUENCE b   CREATE SEQUENCE email_idemail_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 (   DROP SEQUENCE public.email_idemail_seq;
       public       postgres    false    1639    6            �           0    0    email_idemail_seq    SEQUENCE OWNED BY 9   ALTER SEQUENCE email_idemail_seq OWNED BY email.idemail;
            public       postgres    false    1680            �           0    0    email_idemail_seq    SEQUENCE SET 8   SELECT pg_catalog.setval('email_idemail_seq', 9, true);
            public       postgres    false    1680            �           1259    27526    fichatecnica_idfichatecnica_seq    SEQUENCE p   CREATE SEQUENCE fichatecnica_idfichatecnica_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 6   DROP SEQUENCE public.fichatecnica_idfichatecnica_seq;
       public       postgres    false    1640    6            �           0    0    fichatecnica_idfichatecnica_seq    SEQUENCE OWNED BY U   ALTER SEQUENCE fichatecnica_idfichatecnica_seq OWNED BY fichatecnica.idfichatecnica;
            public       postgres    false    1681            �           0    0    fichatecnica_idfichatecnica_seq    SEQUENCE SET F   SELECT pg_catalog.setval('fichatecnica_idfichatecnica_seq', 4, true);
            public       postgres    false    1681            �           1259    27528 #   formapagamento_idformapagamento_seq    SEQUENCE t   CREATE SEQUENCE formapagamento_idformapagamento_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 :   DROP SEQUENCE public.formapagamento_idformapagamento_seq;
       public       postgres    false    6    1642            �           0    0 #   formapagamento_idformapagamento_seq    SEQUENCE OWNED BY ]   ALTER SEQUENCE formapagamento_idformapagamento_seq OWNED BY formapagamento.idformapagamento;
            public       postgres    false    1682            �           0    0 #   formapagamento_idformapagamento_seq    SEQUENCE SET J   SELECT pg_catalog.setval('formapagamento_idformapagamento_seq', 8, true);
            public       postgres    false    1682            �           1259    27530 7   formapagamentofornecedor_idformapagamentofornecedor_seq    SEQUENCE �   CREATE SEQUENCE formapagamentofornecedor_idformapagamentofornecedor_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 N   DROP SEQUENCE public.formapagamentofornecedor_idformapagamentofornecedor_seq;
       public       postgres    false    1643    6            �           0    0 7   formapagamentofornecedor_idformapagamentofornecedor_seq    SEQUENCE OWNED BY �   ALTER SEQUENCE formapagamentofornecedor_idformapagamentofornecedor_seq OWNED BY formapagamentofornecedor.idformapagamentofornecedor;
            public       postgres    false    1683            �           0    0 7   formapagamentofornecedor_idformapagamentofornecedor_seq    SEQUENCE SET ^   SELECT pg_catalog.setval('formapagamentofornecedor_idformapagamentofornecedor_seq', 5, true);
            public       postgres    false    1683            �           1259    27532    fornecedor_idfornecedor_seq    SEQUENCE l   CREATE SEQUENCE fornecedor_idfornecedor_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 2   DROP SEQUENCE public.fornecedor_idfornecedor_seq;
       public       postgres    false    6    1644            �           0    0    fornecedor_idfornecedor_seq    SEQUENCE OWNED BY M   ALTER SEQUENCE fornecedor_idfornecedor_seq OWNED BY fornecedor.idfornecedor;
            public       postgres    false    1684            �           0    0    fornecedor_idfornecedor_seq    SEQUENCE SET C   SELECT pg_catalog.setval('fornecedor_idfornecedor_seq', 20, true);
            public       postgres    false    1684            �           1259    27534 )   fornecedorproduto_idfornecedorproduto_seq    SEQUENCE z   CREATE SEQUENCE fornecedorproduto_idfornecedorproduto_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 @   DROP SEQUENCE public.fornecedorproduto_idfornecedorproduto_seq;
       public       postgres    false    1645    6            �           0    0 )   fornecedorproduto_idfornecedorproduto_seq    SEQUENCE OWNED BY i   ALTER SEQUENCE fornecedorproduto_idfornecedorproduto_seq OWNED BY fornecedorproduto.idfornecedorproduto;
            public       postgres    false    1685            �           0    0 )   fornecedorproduto_idfornecedorproduto_seq    SEQUENCE SET Q   SELECT pg_catalog.setval('fornecedorproduto_idfornecedorproduto_seq', 12, true);
            public       postgres    false    1685            �           1259    27894 %   historicopedido_idhistoricopedido_seq    SEQUENCE v   CREATE SEQUENCE historicopedido_idhistoricopedido_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 <   DROP SEQUENCE public.historicopedido_idhistoricopedido_seq;
       public       postgres    false    1715    6            �           0    0 %   historicopedido_idhistoricopedido_seq    SEQUENCE OWNED BY a   ALTER SEQUENCE historicopedido_idhistoricopedido_seq OWNED BY historicopedido.idhistoricopedido;
            public       postgres    false    1714            �           0    0 %   historicopedido_idhistoricopedido_seq    SEQUENCE SET M   SELECT pg_catalog.setval('historicopedido_idhistoricopedido_seq', 20, true);
            public       postgres    false    1714            �           1259    27943 !   itemavaliacao_iditemavaliacao_seq    SEQUENCE r   CREATE SEQUENCE itemavaliacao_iditemavaliacao_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 8   DROP SEQUENCE public.itemavaliacao_iditemavaliacao_seq;
       public       postgres    false    1719    6            �           0    0 !   itemavaliacao_iditemavaliacao_seq    SEQUENCE OWNED BY Y   ALTER SEQUENCE itemavaliacao_iditemavaliacao_seq OWNED BY itemavaliacao.iditemavaliacao;
            public       postgres    false    1718            �           0    0 !   itemavaliacao_iditemavaliacao_seq    SEQUENCE SET I   SELECT pg_catalog.setval('itemavaliacao_iditemavaliacao_seq', 31, true);
            public       postgres    false    1718            �           1259    27912    itempedido_iditempedido_seq    SEQUENCE l   CREATE SEQUENCE itempedido_iditempedido_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 2   DROP SEQUENCE public.itempedido_iditempedido_seq;
       public       postgres    false    1717    6            �           0    0    itempedido_iditempedido_seq    SEQUENCE OWNED BY M   ALTER SEQUENCE itempedido_iditempedido_seq OWNED BY itempedido.iditempedido;
            public       postgres    false    1716            �           0    0    itempedido_iditempedido_seq    SEQUENCE SET C   SELECT pg_catalog.setval('itempedido_iditempedido_seq', 43, true);
            public       postgres    false    1716            �           1259    27536    logsistema_idlogsistema_seq    SEQUENCE l   CREATE SEQUENCE logsistema_idlogsistema_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 2   DROP SEQUENCE public.logsistema_idlogsistema_seq;
       public       postgres    false    1647    6            �           0    0    logsistema_idlogsistema_seq    SEQUENCE OWNED BY M   ALTER SEQUENCE logsistema_idlogsistema_seq OWNED BY logsistema.idlogsistema;
            public       postgres    false    1686            �           0    0    logsistema_idlogsistema_seq    SEQUENCE SET E   SELECT pg_catalog.setval('logsistema_idlogsistema_seq', 1636, true);
            public       postgres    false    1686            �           1259    27538    mensagens_idmensagem_seq    SEQUENCE i   CREATE SEQUENCE mensagens_idmensagem_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 /   DROP SEQUENCE public.mensagens_idmensagem_seq;
       public       postgres    false    6    1648            �           0    0    mensagens_idmensagem_seq    SEQUENCE OWNED BY G   ALTER SEQUENCE mensagens_idmensagem_seq OWNED BY mensagens.idmensagem;
            public       postgres    false    1687            �           0    0    mensagens_idmensagem_seq    SEQUENCE SET @   SELECT pg_catalog.setval('mensagens_idmensagem_seq', 11, true);
            public       postgres    false    1687            �           1259    27540    motivo_idmotivo_seq    SEQUENCE d   CREATE SEQUENCE motivo_idmotivo_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 *   DROP SEQUENCE public.motivo_idmotivo_seq;
       public       postgres    false    6    1649            �           0    0    motivo_idmotivo_seq    SEQUENCE OWNED BY =   ALTER SEQUENCE motivo_idmotivo_seq OWNED BY motivo.idmotivo;
            public       postgres    false    1688            �           0    0    motivo_idmotivo_seq    SEQUENCE SET ;   SELECT pg_catalog.setval('motivo_idmotivo_seq', 11, true);
            public       postgres    false    1688            �           1259    27542    movimento_idmovimento_seq    SEQUENCE j   CREATE SEQUENCE movimento_idmovimento_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 0   DROP SEQUENCE public.movimento_idmovimento_seq;
       public       postgres    false    6    1650            �           0    0    movimento_idmovimento_seq    SEQUENCE OWNED BY I   ALTER SEQUENCE movimento_idmovimento_seq OWNED BY movimento.idmovimento;
            public       postgres    false    1689            �           0    0    movimento_idmovimento_seq    SEQUENCE SET A   SELECT pg_catalog.setval('movimento_idmovimento_seq', 25, true);
            public       postgres    false    1689            �           1259    27544    operacao_idoperacao_seq    SEQUENCE y   CREATE SEQUENCE operacao_idoperacao_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 .   DROP SEQUENCE public.operacao_idoperacao_seq;
       public       postgres    false    1651    6            �           0    0    operacao_idoperacao_seq    SEQUENCE OWNED BY E   ALTER SEQUENCE operacao_idoperacao_seq OWNED BY operacao.idoperacao;
            public       postgres    false    1690            �           0    0    operacao_idoperacao_seq    SEQUENCE SET ?   SELECT pg_catalog.setval('operacao_idoperacao_seq', 1, false);
            public       postgres    false    1690            �           1259    27546 !   ordemproducao_idordemproducao_seq    SEQUENCE r   CREATE SEQUENCE ordemproducao_idordemproducao_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 8   DROP SEQUENCE public.ordemproducao_idordemproducao_seq;
       public       postgres    false    6    1652            �           0    0 !   ordemproducao_idordemproducao_seq    SEQUENCE OWNED BY Y   ALTER SEQUENCE ordemproducao_idordemproducao_seq OWNED BY ordemproducao.idordemproducao;
            public       postgres    false    1691            �           0    0 !   ordemproducao_idordemproducao_seq    SEQUENCE SET I   SELECT pg_catalog.setval('ordemproducao_idordemproducao_seq', 39, true);
            public       postgres    false    1691            �           1259    27548    ordemproduto_idordemproduto_seq    SEQUENCE p   CREATE SEQUENCE ordemproduto_idordemproduto_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 6   DROP SEQUENCE public.ordemproduto_idordemproduto_seq;
       public       postgres    false    1653    6            �           0    0    ordemproduto_idordemproduto_seq    SEQUENCE OWNED BY U   ALTER SEQUENCE ordemproduto_idordemproduto_seq OWNED BY ordemproduto.idordemproduto;
            public       postgres    false    1692            �           0    0    ordemproduto_idordemproduto_seq    SEQUENCE SET G   SELECT pg_catalog.setval('ordemproduto_idordemproduto_seq', 52, true);
            public       postgres    false    1692            �           1259    27550    origemordem_idorigemordem_seq    SEQUENCE    CREATE SEQUENCE origemordem_idorigemordem_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 4   DROP SEQUENCE public.origemordem_idorigemordem_seq;
       public       postgres    false    6    1654            �           0    0    origemordem_idorigemordem_seq    SEQUENCE OWNED BY Q   ALTER SEQUENCE origemordem_idorigemordem_seq OWNED BY origemordem.idorigemordem;
            public       postgres    false    1693            �           0    0    origemordem_idorigemordem_seq    SEQUENCE SET E   SELECT pg_catalog.setval('origemordem_idorigemordem_seq', 1, false);
            public       postgres    false    1693            �           1259    27886    pedido_idpedido_seq    SEQUENCE d   CREATE SEQUENCE pedido_idpedido_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 *   DROP SEQUENCE public.pedido_idpedido_seq;
       public       postgres    false    6    1713            �           0    0    pedido_idpedido_seq    SEQUENCE OWNED BY =   ALTER SEQUENCE pedido_idpedido_seq OWNED BY pedido.idpedido;
            public       postgres    false    1712            �           0    0    pedido_idpedido_seq    SEQUENCE SET ;   SELECT pg_catalog.setval('pedido_idpedido_seq', 25, true);
            public       postgres    false    1712            �           1259    27552    perfil_idperfil_seq    SEQUENCE d   CREATE SEQUENCE perfil_idperfil_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 *   DROP SEQUENCE public.perfil_idperfil_seq;
       public       postgres    false    6    1655            �           0    0    perfil_idperfil_seq    SEQUENCE OWNED BY =   ALTER SEQUENCE perfil_idperfil_seq OWNED BY perfil.idperfil;
            public       postgres    false    1694            �           0    0    perfil_idperfil_seq    SEQUENCE SET ;   SELECT pg_catalog.setval('perfil_idperfil_seq', 25, true);
            public       postgres    false    1694            �           1259    27554    perfiltela_idperfiltela_seq    SEQUENCE l   CREATE SEQUENCE perfiltela_idperfiltela_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 2   DROP SEQUENCE public.perfiltela_idperfiltela_seq;
       public       postgres    false    6    1656            �           0    0    perfiltela_idperfiltela_seq    SEQUENCE OWNED BY M   ALTER SEQUENCE perfiltela_idperfiltela_seq OWNED BY perfiltela.idperfiltela;
            public       postgres    false    1695            �           0    0    perfiltela_idperfiltela_seq    SEQUENCE SET C   SELECT pg_catalog.setval('perfiltela_idperfiltela_seq', 79, true);
            public       postgres    false    1695            �           1259    27556    produto_idproduto_seq    SEQUENCE f   CREATE SEQUENCE produto_idproduto_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.produto_idproduto_seq;
       public       postgres    false    6    1657            �           0    0    produto_idproduto_seq    SEQUENCE OWNED BY A   ALTER SEQUENCE produto_idproduto_seq OWNED BY produto.idproduto;
            public       postgres    false    1696            �           0    0    produto_idproduto_seq    SEQUENCE SET =   SELECT pg_catalog.setval('produto_idproduto_seq', 18, true);
            public       postgres    false    1696            �           1259    27558    refeicao_idrefeicao_seq    SEQUENCE h   CREATE SEQUENCE refeicao_idrefeicao_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 .   DROP SEQUENCE public.refeicao_idrefeicao_seq;
       public       postgres    false    6    1659            �           0    0    refeicao_idrefeicao_seq    SEQUENCE OWNED BY E   ALTER SEQUENCE refeicao_idrefeicao_seq OWNED BY refeicao.idrefeicao;
            public       postgres    false    1697            �           0    0    refeicao_idrefeicao_seq    SEQUENCE SET >   SELECT pg_catalog.setval('refeicao_idrefeicao_seq', 6, true);
            public       postgres    false    1697            �           1259    27560    saldoano_idano_seq    SEQUENCE c   CREATE SEQUENCE saldoano_idano_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 )   DROP SEQUENCE public.saldoano_idano_seq;
       public       postgres    false    6    1660            �           0    0    saldoano_idano_seq    SEQUENCE OWNED BY @   ALTER SEQUENCE saldoano_idano_seq OWNED BY saldoano.idsaldoano;
            public       postgres    false    1698            �           0    0    saldoano_idano_seq    SEQUENCE SET :   SELECT pg_catalog.setval('saldoano_idano_seq', 81, true);
            public       postgres    false    1698            �           1259    27562    saldodia_idsaldodia_seq    SEQUENCE h   CREATE SEQUENCE saldodia_idsaldodia_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 .   DROP SEQUENCE public.saldodia_idsaldodia_seq;
       public       postgres    false    1661    6            �           0    0    saldodia_idsaldodia_seq    SEQUENCE OWNED BY E   ALTER SEQUENCE saldodia_idsaldodia_seq OWNED BY saldodia.idsaldodia;
            public       postgres    false    1699            �           0    0    saldodia_idsaldodia_seq    SEQUENCE SET @   SELECT pg_catalog.setval('saldodia_idsaldodia_seq', 140, true);
            public       postgres    false    1699            �           1259    27564    saldomes_idsaldomes_seq    SEQUENCE h   CREATE SEQUENCE saldomes_idsaldomes_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 .   DROP SEQUENCE public.saldomes_idsaldomes_seq;
       public       postgres    false    6    1662            �           0    0    saldomes_idsaldomes_seq    SEQUENCE OWNED BY E   ALTER SEQUENCE saldomes_idsaldomes_seq OWNED BY saldomes.idsaldomes;
            public       postgres    false    1700             	           0    0    saldomes_idsaldomes_seq    SEQUENCE SET @   SELECT pg_catalog.setval('saldomes_idsaldomes_seq', 117, true);
            public       postgres    false    1700            �           1259    36186 +   situacaoitempedido_idsituacaoitempedido_seq    SEQUENCE �   CREATE SEQUENCE situacaoitempedido_idsituacaoitempedido_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 B   DROP SEQUENCE public.situacaoitempedido_idsituacaoitempedido_seq;
       public       postgres    false    6    1722            	           0    0 +   situacaoitempedido_idsituacaoitempedido_seq    SEQUENCE OWNED BY m   ALTER SEQUENCE situacaoitempedido_idsituacaoitempedido_seq OWNED BY situacaoitempedido.idsituacaoitempedido;
            public       postgres    false    1721            	           0    0 +   situacaoitempedido_idsituacaoitempedido_seq    SEQUENCE SET S   SELECT pg_catalog.setval('situacaoitempedido_idsituacaoitempedido_seq', 1, false);
            public       postgres    false    1721            �           1259    27566 !   situacaoordem_idsituacaoordem_seq    SEQUENCE �   CREATE SEQUENCE situacaoordem_idsituacaoordem_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 8   DROP SEQUENCE public.situacaoordem_idsituacaoordem_seq;
       public       postgres    false    6    1663            	           0    0 !   situacaoordem_idsituacaoordem_seq    SEQUENCE OWNED BY Y   ALTER SEQUENCE situacaoordem_idsituacaoordem_seq OWNED BY situacaoordem.idsituacaoordem;
            public       postgres    false    1701            	           0    0 !   situacaoordem_idsituacaoordem_seq    SEQUENCE SET I   SELECT pg_catalog.setval('situacaoordem_idsituacaoordem_seq', 1, false);
            public       postgres    false    1701            �           1259    27878 #   situacaopedido_idsituacaopedido_seq    SEQUENCE �   CREATE SEQUENCE situacaopedido_idsituacaopedido_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 :   DROP SEQUENCE public.situacaopedido_idsituacaopedido_seq;
       public       postgres    false    1711    6            	           0    0 #   situacaopedido_idsituacaopedido_seq    SEQUENCE OWNED BY ]   ALTER SEQUENCE situacaopedido_idsituacaopedido_seq OWNED BY situacaopedido.idsituacaopedido;
            public       postgres    false    1710            	           0    0 #   situacaopedido_idsituacaopedido_seq    SEQUENCE SET K   SELECT pg_catalog.setval('situacaopedido_idsituacaopedido_seq', 1, false);
            public       postgres    false    1710            �           1259    27568    tela_idtela_seq    SEQUENCE `   CREATE SEQUENCE tela_idtela_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 &   DROP SEQUENCE public.tela_idtela_seq;
       public       postgres    false    1665    6            	           0    0    tela_idtela_seq    SEQUENCE OWNED BY 5   ALTER SEQUENCE tela_idtela_seq OWNED BY tela.idtela;
            public       postgres    false    1702            	           0    0    tela_idtela_seq    SEQUENCE SET 6   SELECT pg_catalog.setval('tela_idtela_seq', 9, true);
            public       postgres    false    1702            �           1259    27570    telabotao_idtelabotao_seq    SEQUENCE j   CREATE SEQUENCE telabotao_idtelabotao_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 0   DROP SEQUENCE public.telabotao_idtelabotao_seq;
       public       postgres    false    6    1666            		           0    0    telabotao_idtelabotao_seq    SEQUENCE OWNED BY I   ALTER SEQUENCE telabotao_idtelabotao_seq OWNED BY telabotao.idtelabotao;
            public       postgres    false    1703            
	           0    0    telabotao_idtelabotao_seq    SEQUENCE SET A   SELECT pg_catalog.setval('telabotao_idtelabotao_seq', 21, true);
            public       postgres    false    1703            �           1259    27572    telefone_idtelefone_seq    SEQUENCE h   CREATE SEQUENCE telefone_idtelefone_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 .   DROP SEQUENCE public.telefone_idtelefone_seq;
       public       postgres    false    1667    6            	           0    0    telefone_idtelefone_seq    SEQUENCE OWNED BY E   ALTER SEQUENCE telefone_idtelefone_seq OWNED BY telefone.idtelefone;
            public       postgres    false    1704            	           0    0    telefone_idtelefone_seq    SEQUENCE SET >   SELECT pg_catalog.setval('telefone_idtelefone_seq', 9, true);
            public       postgres    false    1704            �           1259    27574 #   tipofornecedor_idtipofornecedor_seq    SEQUENCE �   CREATE SEQUENCE tipofornecedor_idtipofornecedor_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 :   DROP SEQUENCE public.tipofornecedor_idtipofornecedor_seq;
       public       postgres    false    6    1668            	           0    0 #   tipofornecedor_idtipofornecedor_seq    SEQUENCE OWNED BY ]   ALTER SEQUENCE tipofornecedor_idtipofornecedor_seq OWNED BY tipofornecedor.idtipofornecedor;
            public       postgres    false    1705            	           0    0 #   tipofornecedor_idtipofornecedor_seq    SEQUENCE SET K   SELECT pg_catalog.setval('tipofornecedor_idtipofornecedor_seq', 1, false);
            public       postgres    false    1705            �           1259    27576    tipotelefone_idtipotelefone_seq    SEQUENCE �   CREATE SEQUENCE tipotelefone_idtipotelefone_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 6   DROP SEQUENCE public.tipotelefone_idtipotelefone_seq;
       public       postgres    false    6    1669            	           0    0    tipotelefone_idtipotelefone_seq    SEQUENCE OWNED BY U   ALTER SEQUENCE tipotelefone_idtipotelefone_seq OWNED BY tipotelefone.idtipotelefone;
            public       postgres    false    1706            	           0    0    tipotelefone_idtipotelefone_seq    SEQUENCE SET G   SELECT pg_catalog.setval('tipotelefone_idtipotelefone_seq', 1, false);
            public       postgres    false    1706            �           1259    27578 !   ultimousuario_idultimousuario_seq    SEQUENCE r   CREATE SEQUENCE ultimousuario_idultimousuario_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 8   DROP SEQUENCE public.ultimousuario_idultimousuario_seq;
       public       postgres    false    1670    6            	           0    0 !   ultimousuario_idultimousuario_seq    SEQUENCE OWNED BY Y   ALTER SEQUENCE ultimousuario_idultimousuario_seq OWNED BY ultimousuario.idultimousuario;
            public       postgres    false    1707            	           0    0 !   ultimousuario_idultimousuario_seq    SEQUENCE SET H   SELECT pg_catalog.setval('ultimousuario_idultimousuario_seq', 2, true);
            public       postgres    false    1707            �           1259    27580 !   unidademedida_idunidademedida_seq    SEQUENCE r   CREATE SEQUENCE unidademedida_idunidademedida_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 8   DROP SEQUENCE public.unidademedida_idunidademedida_seq;
       public       postgres    false    1671    6            	           0    0 !   unidademedida_idunidademedida_seq    SEQUENCE OWNED BY Y   ALTER SEQUENCE unidademedida_idunidademedida_seq OWNED BY unidademedida.idunidademedida;
            public       postgres    false    1708            	           0    0 !   unidademedida_idunidademedida_seq    SEQUENCE SET H   SELECT pg_catalog.setval('unidademedida_idunidademedida_seq', 8, true);
            public       postgres    false    1708            �           1259    27582    usuario_idusuario_seq    SEQUENCE f   CREATE SEQUENCE usuario_idusuario_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.usuario_idusuario_seq;
       public       postgres    false    1672    6            	           0    0    usuario_idusuario_seq    SEQUENCE OWNED BY A   ALTER SEQUENCE usuario_idusuario_seq OWNED BY usuario.idusuario;
            public       postgres    false    1709            	           0    0    usuario_idusuario_seq    SEQUENCE SET <   SELECT pg_catalog.setval('usuario_idusuario_seq', 3, true);
            public       postgres    false    1709            �           2604    27584    idauditoria    DEFAULT m   ALTER TABLE auditoria ALTER COLUMN idauditoria SET DEFAULT nextval('"Auditoria_idAuditoria_seq"'::regclass);
 D   ALTER TABLE public.auditoria ALTER COLUMN idauditoria DROP DEFAULT;
       public       postgres    false    1674    1630            �           2604    27585    idbotao    DEFAULT [   ALTER TABLE botao ALTER COLUMN idbotao SET DEFAULT nextval('botao_idbotao_seq'::regclass);
 <   ALTER TABLE public.botao ALTER COLUMN idbotao DROP DEFAULT;
       public       postgres    false    1675    1632            �           2604    27586 
   idcardapio    DEFAULT g   ALTER TABLE cardapio ALTER COLUMN idcardapio SET DEFAULT nextval('cardapio_idcardapio_seq'::regclass);
 B   ALTER TABLE public.cardapio ALTER COLUMN idcardapio DROP DEFAULT;
       public       postgres    false    1676    1634            �           2604    27587    idcargo    DEFAULT [   ALTER TABLE cargo ALTER COLUMN idcargo SET DEFAULT nextval('cargo_idcargo_seq'::regclass);
 <   ALTER TABLE public.cargo ALTER COLUMN idcargo DROP DEFAULT;
       public       postgres    false    1677    1636            �           2604    27588    idcomposicaocentesimal    DEFAULT �   ALTER TABLE composicaocentesimal ALTER COLUMN idcomposicaocentesimal SET DEFAULT nextval('composicaocentesimal_idcomposicaocentesimal_seq'::regclass);
 Z   ALTER TABLE public.composicaocentesimal ALTER COLUMN idcomposicaocentesimal DROP DEFAULT;
       public       postgres    false    1678    1637            �           2604    27589    iddadosbancarios    DEFAULT    ALTER TABLE dadosbancarios ALTER COLUMN iddadosbancarios SET DEFAULT nextval('dadosbancarios_iddadosbancarios_seq'::regclass);
 N   ALTER TABLE public.dadosbancarios ALTER COLUMN iddadosbancarios DROP DEFAULT;
       public       postgres    false    1679    1638            �           2604    27590    idemail    DEFAULT [   ALTER TABLE email ALTER COLUMN idemail SET DEFAULT nextval('email_idemail_seq'::regclass);
 <   ALTER TABLE public.email ALTER COLUMN idemail DROP DEFAULT;
       public       postgres    false    1680    1639            �           2604    27591    idfichatecnica    DEFAULT w   ALTER TABLE fichatecnica ALTER COLUMN idfichatecnica SET DEFAULT nextval('fichatecnica_idfichatecnica_seq'::regclass);
 J   ALTER TABLE public.fichatecnica ALTER COLUMN idfichatecnica DROP DEFAULT;
       public       postgres    false    1681    1640            �           2604    27592    idformapagamento    DEFAULT    ALTER TABLE formapagamento ALTER COLUMN idformapagamento SET DEFAULT nextval('formapagamento_idformapagamento_seq'::regclass);
 N   ALTER TABLE public.formapagamento ALTER COLUMN idformapagamento DROP DEFAULT;
       public       postgres    false    1682    1642            �           2604    27593    idformapagamentofornecedor    DEFAULT �   ALTER TABLE formapagamentofornecedor ALTER COLUMN idformapagamentofornecedor SET DEFAULT nextval('formapagamentofornecedor_idformapagamentofornecedor_seq'::regclass);
 b   ALTER TABLE public.formapagamentofornecedor ALTER COLUMN idformapagamentofornecedor DROP DEFAULT;
       public       postgres    false    1683    1643            �           2604    27594    idfornecedor    DEFAULT o   ALTER TABLE fornecedor ALTER COLUMN idfornecedor SET DEFAULT nextval('fornecedor_idfornecedor_seq'::regclass);
 F   ALTER TABLE public.fornecedor ALTER COLUMN idfornecedor DROP DEFAULT;
       public       postgres    false    1684    1644            �           2604    27595    idfornecedorproduto    DEFAULT �   ALTER TABLE fornecedorproduto ALTER COLUMN idfornecedorproduto SET DEFAULT nextval('fornecedorproduto_idfornecedorproduto_seq'::regclass);
 T   ALTER TABLE public.fornecedorproduto ALTER COLUMN idfornecedorproduto DROP DEFAULT;
       public       postgres    false    1685    1645            �           2604    27899    idhistoricopedido    DEFAULT �   ALTER TABLE historicopedido ALTER COLUMN idhistoricopedido SET DEFAULT nextval('historicopedido_idhistoricopedido_seq'::regclass);
 P   ALTER TABLE public.historicopedido ALTER COLUMN idhistoricopedido DROP DEFAULT;
       public       postgres    false    1715    1714    1715            �           2604    27948    iditemavaliacao    DEFAULT {   ALTER TABLE itemavaliacao ALTER COLUMN iditemavaliacao SET DEFAULT nextval('itemavaliacao_iditemavaliacao_seq'::regclass);
 L   ALTER TABLE public.itemavaliacao ALTER COLUMN iditemavaliacao DROP DEFAULT;
       public       postgres    false    1719    1718    1719            �           2604    27987    iditempedido    DEFAULT o   ALTER TABLE itempedido ALTER COLUMN iditempedido SET DEFAULT nextval('itempedido_iditempedido_seq'::regclass);
 F   ALTER TABLE public.itempedido ALTER COLUMN iditempedido DROP DEFAULT;
       public       postgres    false    1716    1717    1717            �           2604    27596    idlogsistema    DEFAULT o   ALTER TABLE logsistema ALTER COLUMN idlogsistema SET DEFAULT nextval('logsistema_idlogsistema_seq'::regclass);
 F   ALTER TABLE public.logsistema ALTER COLUMN idlogsistema DROP DEFAULT;
       public       postgres    false    1686    1647            �           2604    27597 
   idmensagem    DEFAULT i   ALTER TABLE mensagens ALTER COLUMN idmensagem SET DEFAULT nextval('mensagens_idmensagem_seq'::regclass);
 C   ALTER TABLE public.mensagens ALTER COLUMN idmensagem DROP DEFAULT;
       public       postgres    false    1687    1648            �           2604    27598    idmotivo    DEFAULT _   ALTER TABLE motivo ALTER COLUMN idmotivo SET DEFAULT nextval('motivo_idmotivo_seq'::regclass);
 >   ALTER TABLE public.motivo ALTER COLUMN idmotivo DROP DEFAULT;
       public       postgres    false    1688    1649            �           2604    27599    idmovimento    DEFAULT k   ALTER TABLE movimento ALTER COLUMN idmovimento SET DEFAULT nextval('movimento_idmovimento_seq'::regclass);
 D   ALTER TABLE public.movimento ALTER COLUMN idmovimento DROP DEFAULT;
       public       postgres    false    1689    1650            �           2604    27600 
   idoperacao    DEFAULT g   ALTER TABLE operacao ALTER COLUMN idoperacao SET DEFAULT nextval('operacao_idoperacao_seq'::regclass);
 B   ALTER TABLE public.operacao ALTER COLUMN idoperacao DROP DEFAULT;
       public       postgres    false    1690    1651            �           2604    27601    idordemproducao    DEFAULT {   ALTER TABLE ordemproducao ALTER COLUMN idordemproducao SET DEFAULT nextval('ordemproducao_idordemproducao_seq'::regclass);
 L   ALTER TABLE public.ordemproducao ALTER COLUMN idordemproducao DROP DEFAULT;
       public       postgres    false    1691    1652            �           2604    27602    idordemproduto    DEFAULT w   ALTER TABLE ordemproduto ALTER COLUMN idordemproduto SET DEFAULT nextval('ordemproduto_idordemproduto_seq'::regclass);
 J   ALTER TABLE public.ordemproduto ALTER COLUMN idordemproduto DROP DEFAULT;
       public       postgres    false    1692    1653            �           2604    27603    idorigemordem    DEFAULT s   ALTER TABLE origemordem ALTER COLUMN idorigemordem SET DEFAULT nextval('origemordem_idorigemordem_seq'::regclass);
 H   ALTER TABLE public.origemordem ALTER COLUMN idorigemordem DROP DEFAULT;
       public       postgres    false    1693    1654            �           2604    27891    idpedido    DEFAULT _   ALTER TABLE pedido ALTER COLUMN idpedido SET DEFAULT nextval('pedido_idpedido_seq'::regclass);
 >   ALTER TABLE public.pedido ALTER COLUMN idpedido DROP DEFAULT;
       public       postgres    false    1712    1713    1713            �           2604    27604    idperfil    DEFAULT _   ALTER TABLE perfil ALTER COLUMN idperfil SET DEFAULT nextval('perfil_idperfil_seq'::regclass);
 >   ALTER TABLE public.perfil ALTER COLUMN idperfil DROP DEFAULT;
       public       postgres    false    1694    1655            �           2604    27605    idperfiltela    DEFAULT o   ALTER TABLE perfiltela ALTER COLUMN idperfiltela SET DEFAULT nextval('perfiltela_idperfiltela_seq'::regclass);
 F   ALTER TABLE public.perfiltela ALTER COLUMN idperfiltela DROP DEFAULT;
       public       postgres    false    1695    1656            �           2604    27606 	   idproduto    DEFAULT c   ALTER TABLE produto ALTER COLUMN idproduto SET DEFAULT nextval('produto_idproduto_seq'::regclass);
 @   ALTER TABLE public.produto ALTER COLUMN idproduto DROP DEFAULT;
       public       postgres    false    1696    1657            �           2604    27607 
   idrefeicao    DEFAULT g   ALTER TABLE refeicao ALTER COLUMN idrefeicao SET DEFAULT nextval('refeicao_idrefeicao_seq'::regclass);
 B   ALTER TABLE public.refeicao ALTER COLUMN idrefeicao DROP DEFAULT;
       public       postgres    false    1697    1659            �           2604    27608 
   idsaldoano    DEFAULT b   ALTER TABLE saldoano ALTER COLUMN idsaldoano SET DEFAULT nextval('saldoano_idano_seq'::regclass);
 B   ALTER TABLE public.saldoano ALTER COLUMN idsaldoano DROP DEFAULT;
       public       postgres    false    1698    1660            �           2604    27609 
   idsaldodia    DEFAULT g   ALTER TABLE saldodia ALTER COLUMN idsaldodia SET DEFAULT nextval('saldodia_idsaldodia_seq'::regclass);
 B   ALTER TABLE public.saldodia ALTER COLUMN idsaldodia DROP DEFAULT;
       public       postgres    false    1699    1661            �           2604    27610 
   idsaldomes    DEFAULT g   ALTER TABLE saldomes ALTER COLUMN idsaldomes SET DEFAULT nextval('saldomes_idsaldomes_seq'::regclass);
 B   ALTER TABLE public.saldomes ALTER COLUMN idsaldomes DROP DEFAULT;
       public       postgres    false    1700    1662            �           2604    36191    idsituacaoitempedido    DEFAULT �   ALTER TABLE situacaoitempedido ALTER COLUMN idsituacaoitempedido SET DEFAULT nextval('situacaoitempedido_idsituacaoitempedido_seq'::regclass);
 V   ALTER TABLE public.situacaoitempedido ALTER COLUMN idsituacaoitempedido DROP DEFAULT;
       public       postgres    false    1721    1722    1722            �           2604    27611    idsituacaoordem    DEFAULT {   ALTER TABLE situacaoordem ALTER COLUMN idsituacaoordem SET DEFAULT nextval('situacaoordem_idsituacaoordem_seq'::regclass);
 L   ALTER TABLE public.situacaoordem ALTER COLUMN idsituacaoordem DROP DEFAULT;
       public       postgres    false    1701    1663            �           2604    27883    idsituacaopedido    DEFAULT    ALTER TABLE situacaopedido ALTER COLUMN idsituacaopedido SET DEFAULT nextval('situacaopedido_idsituacaopedido_seq'::regclass);
 N   ALTER TABLE public.situacaopedido ALTER COLUMN idsituacaopedido DROP DEFAULT;
       public       postgres    false    1710    1711    1711            �           2604    27612    idtela    DEFAULT W   ALTER TABLE tela ALTER COLUMN idtela SET DEFAULT nextval('tela_idtela_seq'::regclass);
 :   ALTER TABLE public.tela ALTER COLUMN idtela DROP DEFAULT;
       public       postgres    false    1702    1665            �           2604    27613    idtelabotao    DEFAULT k   ALTER TABLE telabotao ALTER COLUMN idtelabotao SET DEFAULT nextval('telabotao_idtelabotao_seq'::regclass);
 D   ALTER TABLE public.telabotao ALTER COLUMN idtelabotao DROP DEFAULT;
       public       postgres    false    1703    1666            �           2604    27614 
   idtelefone    DEFAULT g   ALTER TABLE telefone ALTER COLUMN idtelefone SET DEFAULT nextval('telefone_idtelefone_seq'::regclass);
 B   ALTER TABLE public.telefone ALTER COLUMN idtelefone DROP DEFAULT;
       public       postgres    false    1704    1667            �           2604    27615    idtipofornecedor    DEFAULT    ALTER TABLE tipofornecedor ALTER COLUMN idtipofornecedor SET DEFAULT nextval('tipofornecedor_idtipofornecedor_seq'::regclass);
 N   ALTER TABLE public.tipofornecedor ALTER COLUMN idtipofornecedor DROP DEFAULT;
       public       postgres    false    1705    1668            �           2604    27616    idtipotelefone    DEFAULT w   ALTER TABLE tipotelefone ALTER COLUMN idtipotelefone SET DEFAULT nextval('tipotelefone_idtipotelefone_seq'::regclass);
 J   ALTER TABLE public.tipotelefone ALTER COLUMN idtipotelefone DROP DEFAULT;
       public       postgres    false    1706    1669            �           2604    27617    idultimousuario    DEFAULT {   ALTER TABLE ultimousuario ALTER COLUMN idultimousuario SET DEFAULT nextval('ultimousuario_idultimousuario_seq'::regclass);
 L   ALTER TABLE public.ultimousuario ALTER COLUMN idultimousuario DROP DEFAULT;
       public       postgres    false    1707    1670            �           2604    27618    idunidademedida    DEFAULT {   ALTER TABLE unidademedida ALTER COLUMN idunidademedida SET DEFAULT nextval('unidademedida_idunidademedida_seq'::regclass);
 L   ALTER TABLE public.unidademedida ALTER COLUMN idunidademedida DROP DEFAULT;
       public       postgres    false    1708    1671            �           2604    27619 	   idusuario    DEFAULT c   ALTER TABLE usuario ALTER COLUMN idusuario SET DEFAULT nextval('usuario_idusuario_seq'::regclass);
 @   ALTER TABLE public.usuario ALTER COLUMN idusuario DROP DEFAULT;
       public       postgres    false    1709    1672            �          0    27337 	   auditoria 
   TABLE DATA           c   COPY auditoria (idauditoria, dataoperacao, log, operacao, dados, tabela, idreferencia) FROM stdin;
    public       postgres    false    1630            �          0    27343    banco 
   TABLE DATA           '   COPY banco (nome, idbanco) FROM stdin;
    public       postgres    false    1631            �          0    27346    botao 
   TABLE DATA           I   COPY botao (idbotao, titulobotao, nomebotao, descricaobotao) FROM stdin;
    public       postgres    false    1632            �          0    27352    cardapio 
   TABLE DATA           P   COPY cardapio (idcardapio, datacardapio, qtderefeicoes, idrefeicao) FROM stdin;
    public       postgres    false    1634            �          0    27355    cardapioficha 
   TABLE DATA           <   COPY cardapioficha (idcardapio, idfichatecnica) FROM stdin;
    public       postgres    false    1635            �          0    27358    cargo 
   TABLE DATA           ,   COPY cargo (idcargo, descricao) FROM stdin;
    public       postgres    false    1636            �          0    27361    composicaocentesimal 
   TABLE DATA           �   COPY composicaocentesimal (idcomposicaocentesimal, energia, carboidrato, proteina, lipideo, calcio, ferro, vitaminac) FROM stdin;
    public       postgres    false    1637            �          0    27988    configuracoes 
   TABLE DATA           b   COPY configuracoes (remetente, senha, textomensagem, titulomensagem, idconfiguracoes) FROM stdin;
    public       postgres    false    1720            �          0    27364    dadosbancarios 
   TABLE DATA           i   COPY dadosbancarios (iddadosbancarios, idbanco, agencia, contacorrente, contacorrentedigito) FROM stdin;
    public       postgres    false    1638            �          0    27367    email 
   TABLE DATA           6   COPY email (idemail, email, idfornecedor) FROM stdin;
    public       postgres    false    1639            �          0    27370    fichatecnica 
   TABLE DATA           �   COPY fichatecnica (idfichatecnica, nomepreparacao, modopreparo, rendimento, energia, carboidrato, proteina, lipideo, calcio, ferro, vitaminac, pesocru, pesoliquido, precototal) FROM stdin;
    public       postgres    false    1640            �          0    27373    fichatecnicaitens 
   TABLE DATA           f   COPY fichatecnicaitens (idfichatecnica, idproduto, pesobruto, pesoliquido, fatorcorrecao) FROM stdin;
    public       postgres    false    1641            �          0    27376    formapagamento 
   TABLE DATA           K   COPY formapagamento (idformapagamento, nome, operacaobancaria) FROM stdin;
    public       postgres    false    1642            �          0    27379    formapagamentofornecedor 
   TABLE DATA           g   COPY formapagamentofornecedor (idformapagamentofornecedor, idformapagamento, idfornecedor) FROM stdin;
    public       postgres    false    1643            �          0    27382 
   fornecedor 
   TABLE DATA           �   COPY fornecedor (idfornecedor, codigo, razaosocial, cnpj, inscricaoestadual, ccm, cgc, rua, numero, bairro, cidade, cep, site, tempoentrega, iddadosbancarios) FROM stdin;
    public       postgres    false    1644            �          0    27386    fornecedorproduto 
   TABLE DATA           �   COPY fornecedorproduto (idfornecedorproduto, idproduto, idfornecedor, codprodutofornecedor, tempoentrega, idtipofornecedor) FROM stdin;
    public       postgres    false    1645            �          0    27896    historicopedido 
   TABLE DATA           f   COPY historicopedido (idhistoricopedido, idpedido, idsituacaopedido, datahistoricopedido) FROM stdin;
    public       postgres    false    1715            �          0    27945    itemavaliacao 
   TABLE DATA           x   COPY itemavaliacao (iditemavaliacao, iditempedido, idmotivo, idsituacaoitempedido, adequado, dataavaliacao) FROM stdin;
    public       postgres    false    1719            �          0    27914 
   itempedido 
   TABLE DATA           ]   COPY itempedido (iditempedido, idpedido, idproduto, quantidade, idunidademedida) FROM stdin;
    public       postgres    false    1717            �          0    27392 
   logsistema 
   TABLE DATA           W   COPY logsistema (horario, operacao, logvinculado, idlogsistema, idusuario) FROM stdin;
    public       postgres    false    1647            �          0    27395 	   mensagens 
   TABLE DATA           @   COPY mensagens (idmensagem, mensagem, tipomensagem) FROM stdin;
    public       postgres    false    1648            �          0    27399    motivo 
   TABLE DATA           1   COPY motivo (idmotivo, nome, baixar) FROM stdin;
    public       postgres    false    1649            �          0    27402 	   movimento 
   TABLE DATA           |   COPY movimento (idmovimento, idproduto, quantidade, idunidademedida, idoperacao, motivooperacao, datamovimento) FROM stdin;
    public       postgres    false    1650            �          0    27405    operacao 
   TABLE DATA           ;   COPY operacao (idoperacao, descricao, vlfator) FROM stdin;
    public       postgres    false    1651            �          0    27408    ordemproducao 
   TABLE DATA           w   COPY ordemproducao (idordemproducao, dataordem, idrefeicao, idorigemordem, idsituacaoordem, setor, motivo) FROM stdin;
    public       postgres    false    1652            �          0    27411    ordemproduto 
   TABLE DATA           h   COPY ordemproduto (idordemproducao, idproduto, quantidade, idunidademedida, idordemproduto) FROM stdin;
    public       postgres    false    1653            �          0    27414    origemordem 
   TABLE DATA           8   COPY origemordem (idorigemordem, descricao) FROM stdin;
    public       postgres    false    1654            �          0    27888    pedido 
   TABLE DATA           >   COPY pedido (idpedido, idfornecedor, dataentrega) FROM stdin;
    public       postgres    false    1713            �          0    27417    perfil 
   TABLE DATA           8   COPY perfil (idperfil, nome, administrador) FROM stdin;
    public       postgres    false    1655            �          0    27420 
   perfiltela 
   TABLE DATA           F   COPY perfiltela (idperfiltela, idperfil, idtela, idbotao) FROM stdin;
    public       postgres    false    1656            �          0    27423    produto 
   TABLE DATA           �   COPY produto (idproduto, codigo, nome, valor, estoqueminimo, qtdeembalagem, temperaturaentrega, alimentar, idcomposicaocentesimal, unidadeembalagem, unidadeestoque) FROM stdin;
    public       postgres    false    1657            �          0    27429    refeicao 
   TABLE DATA           2   COPY refeicao (idrefeicao, descricao) FROM stdin;
    public       postgres    false    1659            �          0    27432    saldoano 
   TABLE DATA           s   COPY saldoano (idsaldoano, ano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto) FROM stdin;
    public       postgres    false    1660            �          0    27439    saldodia 
   TABLE DATA           �   COPY saldodia (idsaldodia, datasaldodia, saldosaida, saldoentrada, saldocomprometido, saldopendente, idsaldomes, idproduto) FROM stdin;
    public       postgres    false    1661            �          0    27446    saldomes 
   TABLE DATA              COPY saldomes (idsaldomes, mes, idsaldoano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto) FROM stdin;
    public       postgres    false    1662            �          0    36188    situacaoitempedido 
   TABLE DATA           F   COPY situacaoitempedido (idsituacaoitempedido, descricao) FROM stdin;
    public       postgres    false    1722            �          0    27453    situacaoordem 
   TABLE DATA           <   COPY situacaoordem (idsituacaoordem, descricao) FROM stdin;
    public       postgres    false    1663            �          0    27880    situacaopedido 
   TABLE DATA           >   COPY situacaopedido (idsituacaopedido, descricao) FROM stdin;
    public       postgres    false    1711            �          0    27459    tela 
   TABLE DATA           A   COPY tela (idtela, titulotela, nometela, titulomenu) FROM stdin;
    public       postgres    false    1665            �          0    27462 	   telabotao 
   TABLE DATA           :   COPY telabotao (idtelabotao, idtela, idbotao) FROM stdin;
    public       postgres    false    1666            �          0    27465    telefone 
   TABLE DATA           T   COPY telefone (idtelefone, ddd, telefone, idfornecedor, idtipotelefone) FROM stdin;
    public       postgres    false    1667            �          0    27468    tipofornecedor 
   TABLE DATA           >   COPY tipofornecedor (idtipofornecedor, descricao) FROM stdin;
    public       postgres    false    1668            �          0    27471    tipotelefone 
   TABLE DATA           :   COPY tipotelefone (idtipotelefone, descricao) FROM stdin;
    public       postgres    false    1669            �          0    27474    ultimousuario 
   TABLE DATA           :   COPY ultimousuario (usuario, idultimousuario) FROM stdin;
    public       postgres    false    1670            �          0    27477    unidademedida 
   TABLE DATA           U   COPY unidademedida (idunidademedida, nome, miligrama, grama, quilograma) FROM stdin;
    public       postgres    false    1671            �          0    27480    usuario 
   TABLE DATA           S   COPY usuario (idusuario, idcargo, idperfil, nomeusuario, senha, login) FROM stdin;
    public       postgres    false    1672            �           2606    27621    Auditoria_pkey 
   CONSTRAINT Z   ALTER TABLE ONLY auditoria
    ADD CONSTRAINT "Auditoria_pkey" PRIMARY KEY (idauditoria);
 D   ALTER TABLE ONLY public.auditoria DROP CONSTRAINT "Auditoria_pkey";
       public         postgres    false    1630    1630                        2606    27623    banco_idbanco_key 
   CONSTRAINT N   ALTER TABLE ONLY banco
    ADD CONSTRAINT banco_idbanco_key UNIQUE (idbanco);
 A   ALTER TABLE ONLY public.banco DROP CONSTRAINT banco_idbanco_key;
       public         postgres    false    1631    1631                       2606    27625 
   botao_pkey 
   CONSTRAINT L   ALTER TABLE ONLY botao
    ADD CONSTRAINT botao_pkey PRIMARY KEY (idbotao);
 :   ALTER TABLE ONLY public.botao DROP CONSTRAINT botao_pkey;
       public         postgres    false    1632    1632                       2606    27627    cardapio_pkey 
   CONSTRAINT U   ALTER TABLE ONLY cardapio
    ADD CONSTRAINT cardapio_pkey PRIMARY KEY (idcardapio);
 @   ALTER TABLE ONLY public.cardapio DROP CONSTRAINT cardapio_pkey;
       public         postgres    false    1634    1634                       2606    27629    cardapioficha_pkey 
   CONSTRAINT o   ALTER TABLE ONLY cardapioficha
    ADD CONSTRAINT cardapioficha_pkey PRIMARY KEY (idcardapio, idfichatecnica);
 J   ALTER TABLE ONLY public.cardapioficha DROP CONSTRAINT cardapioficha_pkey;
       public         postgres    false    1635    1635    1635                       2606    27631 
   cargo_pkey 
   CONSTRAINT L   ALTER TABLE ONLY cargo
    ADD CONSTRAINT cargo_pkey PRIMARY KEY (idcargo);
 :   ALTER TABLE ONLY public.cargo DROP CONSTRAINT cargo_pkey;
       public         postgres    false    1636    1636            
           2606    27633    composicaocentesimal_pkey 
   CONSTRAINT y   ALTER TABLE ONLY composicaocentesimal
    ADD CONSTRAINT composicaocentesimal_pkey PRIMARY KEY (idcomposicaocentesimal);
 X   ALTER TABLE ONLY public.composicaocentesimal DROP CONSTRAINT composicaocentesimal_pkey;
       public         postgres    false    1637    1637            Z           2606    36181    configuracoes_pkey 
   CONSTRAINT d   ALTER TABLE ONLY configuracoes
    ADD CONSTRAINT configuracoes_pkey PRIMARY KEY (idconfiguracoes);
 J   ALTER TABLE ONLY public.configuracoes DROP CONSTRAINT configuracoes_pkey;
       public         postgres    false    1720    1720                       2606    27635    dadosbancarios_pkey 
   CONSTRAINT g   ALTER TABLE ONLY dadosbancarios
    ADD CONSTRAINT dadosbancarios_pkey PRIMARY KEY (iddadosbancarios);
 L   ALTER TABLE ONLY public.dadosbancarios DROP CONSTRAINT dadosbancarios_pkey;
       public         postgres    false    1638    1638                       2606    27637 
   email_pkey 
   CONSTRAINT L   ALTER TABLE ONLY email
    ADD CONSTRAINT email_pkey PRIMARY KEY (idemail);
 :   ALTER TABLE ONLY public.email DROP CONSTRAINT email_pkey;
       public         postgres    false    1639    1639                       2606    27639    fichatecnica_pkey 
   CONSTRAINT a   ALTER TABLE ONLY fichatecnica
    ADD CONSTRAINT fichatecnica_pkey PRIMARY KEY (idfichatecnica);
 H   ALTER TABLE ONLY public.fichatecnica DROP CONSTRAINT fichatecnica_pkey;
       public         postgres    false    1640    1640                       2606    27641    fichatecnicaitens_pkey 
   CONSTRAINT v   ALTER TABLE ONLY fichatecnicaitens
    ADD CONSTRAINT fichatecnicaitens_pkey PRIMARY KEY (idfichatecnica, idproduto);
 R   ALTER TABLE ONLY public.fichatecnicaitens DROP CONSTRAINT fichatecnicaitens_pkey;
       public         postgres    false    1641    1641    1641                       2606    27643    formapagamento_pkey 
   CONSTRAINT g   ALTER TABLE ONLY formapagamento
    ADD CONSTRAINT formapagamento_pkey PRIMARY KEY (idformapagamento);
 L   ALTER TABLE ONLY public.formapagamento DROP CONSTRAINT formapagamento_pkey;
       public         postgres    false    1642    1642                       2606    27645    formapagamentofornecedor_pkey 
   CONSTRAINT �   ALTER TABLE ONLY formapagamentofornecedor
    ADD CONSTRAINT formapagamentofornecedor_pkey PRIMARY KEY (idformapagamentofornecedor);
 `   ALTER TABLE ONLY public.formapagamentofornecedor DROP CONSTRAINT formapagamentofornecedor_pkey;
       public         postgres    false    1643    1643                       2606    27647    fornecedor_codigo_key 
   CONSTRAINT V   ALTER TABLE ONLY fornecedor
    ADD CONSTRAINT fornecedor_codigo_key UNIQUE (codigo);
 J   ALTER TABLE ONLY public.fornecedor DROP CONSTRAINT fornecedor_codigo_key;
       public         postgres    false    1644    1644                       2606    27649    fornecedor_pkey 
   CONSTRAINT [   ALTER TABLE ONLY fornecedor
    ADD CONSTRAINT fornecedor_pkey PRIMARY KEY (idfornecedor);
 D   ALTER TABLE ONLY public.fornecedor DROP CONSTRAINT fornecedor_pkey;
       public         postgres    false    1644    1644                       2606    27651    fornecedorproduto_pkey 
   CONSTRAINT p   ALTER TABLE ONLY fornecedorproduto
    ADD CONSTRAINT fornecedorproduto_pkey PRIMARY KEY (idfornecedorproduto);
 R   ALTER TABLE ONLY public.fornecedorproduto DROP CONSTRAINT fornecedorproduto_pkey;
       public         postgres    false    1645    1645            T           2606    27901    historicopedido_pkey 
   CONSTRAINT j   ALTER TABLE ONLY historicopedido
    ADD CONSTRAINT historicopedido_pkey PRIMARY KEY (idhistoricopedido);
 N   ALTER TABLE ONLY public.historicopedido DROP CONSTRAINT historicopedido_pkey;
       public         postgres    false    1715    1715            X           2606    27950    iditemavaliacao_pkey 
   CONSTRAINT f   ALTER TABLE ONLY itemavaliacao
    ADD CONSTRAINT iditemavaliacao_pkey PRIMARY KEY (iditemavaliacao);
 L   ALTER TABLE ONLY public.itemavaliacao DROP CONSTRAINT iditemavaliacao_pkey;
       public         postgres    false    1719    1719                       2606    27653    logsistema_pkey 
   CONSTRAINT [   ALTER TABLE ONLY logsistema
    ADD CONSTRAINT logsistema_pkey PRIMARY KEY (idlogsistema);
 D   ALTER TABLE ONLY public.logsistema DROP CONSTRAINT logsistema_pkey;
       public         postgres    false    1647    1647                        2606    27655    mensagens_pkey 
   CONSTRAINT W   ALTER TABLE ONLY mensagens
    ADD CONSTRAINT mensagens_pkey PRIMARY KEY (idmensagem);
 B   ALTER TABLE ONLY public.mensagens DROP CONSTRAINT mensagens_pkey;
       public         postgres    false    1648    1648            "           2606    27657    motivo_pkey 
   CONSTRAINT O   ALTER TABLE ONLY motivo
    ADD CONSTRAINT motivo_pkey PRIMARY KEY (idmotivo);
 <   ALTER TABLE ONLY public.motivo DROP CONSTRAINT motivo_pkey;
       public         postgres    false    1649    1649            $           2606    27659    movimento_pkey 
   CONSTRAINT X   ALTER TABLE ONLY movimento
    ADD CONSTRAINT movimento_pkey PRIMARY KEY (idmovimento);
 B   ALTER TABLE ONLY public.movimento DROP CONSTRAINT movimento_pkey;
       public         postgres    false    1650    1650            &           2606    27661    operacao_pkey 
   CONSTRAINT U   ALTER TABLE ONLY operacao
    ADD CONSTRAINT operacao_pkey PRIMARY KEY (idoperacao);
 @   ALTER TABLE ONLY public.operacao DROP CONSTRAINT operacao_pkey;
       public         postgres    false    1651    1651            (           2606    27663    ordemproducao_pkey 
   CONSTRAINT d   ALTER TABLE ONLY ordemproducao
    ADD CONSTRAINT ordemproducao_pkey PRIMARY KEY (idordemproducao);
 J   ALTER TABLE ONLY public.ordemproducao DROP CONSTRAINT ordemproducao_pkey;
       public         postgres    false    1652    1652            *           2606    27665    ordemproduto_pkey 
   CONSTRAINT a   ALTER TABLE ONLY ordemproduto
    ADD CONSTRAINT ordemproduto_pkey PRIMARY KEY (idordemproduto);
 H   ALTER TABLE ONLY public.ordemproduto DROP CONSTRAINT ordemproduto_pkey;
       public         postgres    false    1653    1653            ,           2606    27667    origemordem_pkey 
   CONSTRAINT ^   ALTER TABLE ONLY origemordem
    ADD CONSTRAINT origemordem_pkey PRIMARY KEY (idorigemordem);
 F   ALTER TABLE ONLY public.origemordem DROP CONSTRAINT origemordem_pkey;
       public         postgres    false    1654    1654            R           2606    27893    pedido_pkey 
   CONSTRAINT O   ALTER TABLE ONLY pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (idpedido);
 <   ALTER TABLE ONLY public.pedido DROP CONSTRAINT pedido_pkey;
       public         postgres    false    1713    1713            V           2606    27919    pedidoproduto_pkey 
   CONSTRAINT ^   ALTER TABLE ONLY itempedido
    ADD CONSTRAINT pedidoproduto_pkey PRIMARY KEY (iditempedido);
 G   ALTER TABLE ONLY public.itempedido DROP CONSTRAINT pedidoproduto_pkey;
       public         postgres    false    1717    1717            .           2606    27669    perfil_pkey 
   CONSTRAINT O   ALTER TABLE ONLY perfil
    ADD CONSTRAINT perfil_pkey PRIMARY KEY (idperfil);
 <   ALTER TABLE ONLY public.perfil DROP CONSTRAINT perfil_pkey;
       public         postgres    false    1655    1655            0           2606    27671    perfiltela_pkey 
   CONSTRAINT [   ALTER TABLE ONLY perfiltela
    ADD CONSTRAINT perfiltela_pkey PRIMARY KEY (idperfiltela);
 D   ALTER TABLE ONLY public.perfiltela DROP CONSTRAINT perfiltela_pkey;
       public         postgres    false    1656    1656            2           2606    27673    produto_codigo_key 
   CONSTRAINT P   ALTER TABLE ONLY produto
    ADD CONSTRAINT produto_codigo_key UNIQUE (codigo);
 D   ALTER TABLE ONLY public.produto DROP CONSTRAINT produto_codigo_key;
       public         postgres    false    1657    1657            4           2606    27675    produto_pkey 
   CONSTRAINT R   ALTER TABLE ONLY produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (idproduto);
 >   ALTER TABLE ONLY public.produto DROP CONSTRAINT produto_pkey;
       public         postgres    false    1657    1657            6           2606    27677    refeicao_pkey 
   CONSTRAINT U   ALTER TABLE ONLY refeicao
    ADD CONSTRAINT refeicao_pkey PRIMARY KEY (idrefeicao);
 @   ALTER TABLE ONLY public.refeicao DROP CONSTRAINT refeicao_pkey;
       public         postgres    false    1659    1659            8           2606    27679    saldoano_pkey 
   CONSTRAINT U   ALTER TABLE ONLY saldoano
    ADD CONSTRAINT saldoano_pkey PRIMARY KEY (idsaldoano);
 @   ALTER TABLE ONLY public.saldoano DROP CONSTRAINT saldoano_pkey;
       public         postgres    false    1660    1660            :           2606    27681    saldodia_pkey 
   CONSTRAINT U   ALTER TABLE ONLY saldodia
    ADD CONSTRAINT saldodia_pkey PRIMARY KEY (idsaldodia);
 @   ALTER TABLE ONLY public.saldodia DROP CONSTRAINT saldodia_pkey;
       public         postgres    false    1661    1661            <           2606    27683    saldomes_pkey 
   CONSTRAINT U   ALTER TABLE ONLY saldomes
    ADD CONSTRAINT saldomes_pkey PRIMARY KEY (idsaldomes);
 @   ALTER TABLE ONLY public.saldomes DROP CONSTRAINT saldomes_pkey;
       public         postgres    false    1662    1662            \           2606    36193    situacaoitempedido_pkey 
   CONSTRAINT s   ALTER TABLE ONLY situacaoitempedido
    ADD CONSTRAINT situacaoitempedido_pkey PRIMARY KEY (idsituacaoitempedido);
 T   ALTER TABLE ONLY public.situacaoitempedido DROP CONSTRAINT situacaoitempedido_pkey;
       public         postgres    false    1722    1722            >           2606    27685    situacaoordem_pkey 
   CONSTRAINT d   ALTER TABLE ONLY situacaoordem
    ADD CONSTRAINT situacaoordem_pkey PRIMARY KEY (idsituacaoordem);
 J   ALTER TABLE ONLY public.situacaoordem DROP CONSTRAINT situacaoordem_pkey;
       public         postgres    false    1663    1663            P           2606    27885    situacaopedido_pkey 
   CONSTRAINT g   ALTER TABLE ONLY situacaopedido
    ADD CONSTRAINT situacaopedido_pkey PRIMARY KEY (idsituacaopedido);
 L   ALTER TABLE ONLY public.situacaopedido DROP CONSTRAINT situacaopedido_pkey;
       public         postgres    false    1711    1711            @           2606    27687 	   tela_pkey 
   CONSTRAINT I   ALTER TABLE ONLY tela
    ADD CONSTRAINT tela_pkey PRIMARY KEY (idtela);
 8   ALTER TABLE ONLY public.tela DROP CONSTRAINT tela_pkey;
       public         postgres    false    1665    1665            B           2606    27689    telabotao_pkey 
   CONSTRAINT X   ALTER TABLE ONLY telabotao
    ADD CONSTRAINT telabotao_pkey PRIMARY KEY (idtelabotao);
 B   ALTER TABLE ONLY public.telabotao DROP CONSTRAINT telabotao_pkey;
       public         postgres    false    1666    1666            D           2606    27691    telefone_pkey 
   CONSTRAINT U   ALTER TABLE ONLY telefone
    ADD CONSTRAINT telefone_pkey PRIMARY KEY (idtelefone);
 @   ALTER TABLE ONLY public.telefone DROP CONSTRAINT telefone_pkey;
       public         postgres    false    1667    1667            F           2606    27693    telefone_telefone_key 
   CONSTRAINT V   ALTER TABLE ONLY telefone
    ADD CONSTRAINT telefone_telefone_key UNIQUE (telefone);
 H   ALTER TABLE ONLY public.telefone DROP CONSTRAINT telefone_telefone_key;
       public         postgres    false    1667    1667            H           2606    27695    tipofornecedor_pkey 
   CONSTRAINT g   ALTER TABLE ONLY tipofornecedor
    ADD CONSTRAINT tipofornecedor_pkey PRIMARY KEY (idtipofornecedor);
 L   ALTER TABLE ONLY public.tipofornecedor DROP CONSTRAINT tipofornecedor_pkey;
       public         postgres    false    1668    1668            J           2606    27697    tipotelefone_pkey 
   CONSTRAINT a   ALTER TABLE ONLY tipotelefone
    ADD CONSTRAINT tipotelefone_pkey PRIMARY KEY (idtipotelefone);
 H   ALTER TABLE ONLY public.tipotelefone DROP CONSTRAINT tipotelefone_pkey;
       public         postgres    false    1669    1669            L           2606    27699    unidademedida_pkey 
   CONSTRAINT d   ALTER TABLE ONLY unidademedida
    ADD CONSTRAINT unidademedida_pkey PRIMARY KEY (idunidademedida);
 J   ALTER TABLE ONLY public.unidademedida DROP CONSTRAINT unidademedida_pkey;
       public         postgres    false    1671    1671            N           2606    27701    usuario_pkey 
   CONSTRAINT R   ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (idusuario);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public         postgres    false    1672    1672            �           2620    27702    GravarLog_Banco    TRIGGER �   CREATE TRIGGER "GravarLog_Banco"
    AFTER INSERT OR DELETE OR UPDATE ON banco
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 0   DROP TRIGGER "GravarLog_Banco" ON public.banco;
       public       postgres    false    1631    20            �           2620    27703    GravarLog_Botao    TRIGGER �   CREATE TRIGGER "GravarLog_Botao"
    AFTER INSERT OR DELETE OR UPDATE ON botao
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 0   DROP TRIGGER "GravarLog_Botao" ON public.botao;
       public       postgres    false    20    1632            �           2620    27704    GravarLog_Cargo    TRIGGER �   CREATE TRIGGER "GravarLog_Cargo"
    AFTER INSERT OR DELETE OR UPDATE ON cargo
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 0   DROP TRIGGER "GravarLog_Cargo" ON public.cargo;
       public       postgres    false    1636    20            �           2620    27705    GravarLog_FormaPagamento    TRIGGER �   CREATE TRIGGER "GravarLog_FormaPagamento"
    AFTER INSERT OR DELETE OR UPDATE ON formapagamento
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 B   DROP TRIGGER "GravarLog_FormaPagamento" ON public.formapagamento;
       public       postgres    false    20    1642            �           2620    27706    GravarLog_Motivo    TRIGGER �   CREATE TRIGGER "GravarLog_Motivo"
    AFTER INSERT OR DELETE OR UPDATE ON motivo
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 2   DROP TRIGGER "GravarLog_Motivo" ON public.motivo;
       public       postgres    false    20    1649            �           2620    27707    GravarLog_Perfil    TRIGGER �   CREATE TRIGGER "GravarLog_Perfil"
    AFTER INSERT OR DELETE OR UPDATE ON perfil
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 2   DROP TRIGGER "GravarLog_Perfil" ON public.perfil;
       public       postgres    false    20    1655            �           2620    27708    GravarLog_PerfilTela    TRIGGER �   CREATE TRIGGER "GravarLog_PerfilTela"
    AFTER INSERT OR DELETE OR UPDATE ON perfiltela
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 :   DROP TRIGGER "GravarLog_PerfilTela" ON public.perfiltela;
       public       postgres    false    1656    20            �           2620    27709    GravarLog_Tela    TRIGGER �   CREATE TRIGGER "GravarLog_Tela"
    AFTER INSERT OR DELETE OR UPDATE ON tela
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 .   DROP TRIGGER "GravarLog_Tela" ON public.tela;
       public       postgres    false    20    1665            �           2620    27710    GravarLog_TelaBotao    TRIGGER �   CREATE TRIGGER "GravarLog_TelaBotao"
    AFTER INSERT OR DELETE OR UPDATE ON telabotao
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 8   DROP TRIGGER "GravarLog_TelaBotao" ON public.telabotao;
       public       postgres    false    1666    20            �           2620    27711    GravarLog_UnidadeMedida    TRIGGER �   CREATE TRIGGER "GravarLog_UnidadeMedida"
    AFTER INSERT OR DELETE OR UPDATE ON unidademedida
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 @   DROP TRIGGER "GravarLog_UnidadeMedida" ON public.unidademedida;
       public       postgres    false    1671    20            �           2620    27712    GravarLog_Usuario    TRIGGER �   CREATE TRIGGER "GravarLog_Usuario"
    AFTER INSERT OR DELETE OR UPDATE ON usuario
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 4   DROP TRIGGER "GravarLog_Usuario" ON public.usuario;
       public       postgres    false    20    1672            }           2606    27713    FKidusuario_idcargo    FK CONSTRAINT s   ALTER TABLE ONLY usuario
    ADD CONSTRAINT "FKidusuario_idcargo" FOREIGN KEY (idcargo) REFERENCES cargo(idcargo);
 G   ALTER TABLE ONLY public.usuario DROP CONSTRAINT "FKidusuario_idcargo";
       public       postgres    false    2055    1636    1672            ]           2606    27718    cardapioficha_idcardapio_fkey    FK CONSTRAINT �   ALTER TABLE ONLY cardapioficha
    ADD CONSTRAINT cardapioficha_idcardapio_fkey FOREIGN KEY (idcardapio) REFERENCES cardapio(idcardapio);
 U   ALTER TABLE ONLY public.cardapioficha DROP CONSTRAINT cardapioficha_idcardapio_fkey;
       public       postgres    false    2051    1634    1635            ^           2606    27723 !   cardapioficha_idfichatecnica_fkey    FK CONSTRAINT �   ALTER TABLE ONLY cardapioficha
    ADD CONSTRAINT cardapioficha_idfichatecnica_fkey FOREIGN KEY (idfichatecnica) REFERENCES fichatecnica(idfichatecnica);
 Y   ALTER TABLE ONLY public.cardapioficha DROP CONSTRAINT cardapioficha_idfichatecnica_fkey;
       public       postgres    false    1640    2063    1635            _           2606    27728    dadosbancarios_idbanco_fkey    FK CONSTRAINT �   ALTER TABLE ONLY dadosbancarios
    ADD CONSTRAINT dadosbancarios_idbanco_fkey FOREIGN KEY (idbanco) REFERENCES banco(idbanco);
 T   ALTER TABLE ONLY public.dadosbancarios DROP CONSTRAINT dadosbancarios_idbanco_fkey;
       public       postgres    false    2047    1638    1631            `           2606    27733    email_idfornecedor_fkey    FK CONSTRAINT �   ALTER TABLE ONLY email
    ADD CONSTRAINT email_idfornecedor_fkey FOREIGN KEY (idfornecedor) REFERENCES fornecedor(idfornecedor);
 G   ALTER TABLE ONLY public.email DROP CONSTRAINT email_idfornecedor_fkey;
       public       postgres    false    1644    2073    1639            a           2606    27738 .   formapagamentofornecedor_idformapagamento_fkey    FK CONSTRAINT �   ALTER TABLE ONLY formapagamentofornecedor
    ADD CONSTRAINT formapagamentofornecedor_idformapagamento_fkey FOREIGN KEY (idformapagamento) REFERENCES formapagamento(idformapagamento);
 q   ALTER TABLE ONLY public.formapagamentofornecedor DROP CONSTRAINT formapagamentofornecedor_idformapagamento_fkey;
       public       postgres    false    1643    2067    1642            b           2606    27743 *   formapagamentofornecedor_idfornecedor_fkey    FK CONSTRAINT �   ALTER TABLE ONLY formapagamentofornecedor
    ADD CONSTRAINT formapagamentofornecedor_idfornecedor_fkey FOREIGN KEY (idfornecedor) REFERENCES fornecedor(idfornecedor);
 m   ALTER TABLE ONLY public.formapagamentofornecedor DROP CONSTRAINT formapagamentofornecedor_idfornecedor_fkey;
       public       postgres    false    1644    1643    2073            c           2606    27748     fornecedor_iddadosbancarios_fkey    FK CONSTRAINT �   ALTER TABLE ONLY fornecedor
    ADD CONSTRAINT fornecedor_iddadosbancarios_fkey FOREIGN KEY (iddadosbancarios) REFERENCES dadosbancarios(iddadosbancarios);
 U   ALTER TABLE ONLY public.fornecedor DROP CONSTRAINT fornecedor_iddadosbancarios_fkey;
       public       postgres    false    2059    1638    1644            d           2606    27753 #   fornecedorproduto_idfornecedor_fkey    FK CONSTRAINT �   ALTER TABLE ONLY fornecedorproduto
    ADD CONSTRAINT fornecedorproduto_idfornecedor_fkey FOREIGN KEY (idfornecedor) REFERENCES fornecedor(idfornecedor);
 _   ALTER TABLE ONLY public.fornecedorproduto DROP CONSTRAINT fornecedorproduto_idfornecedor_fkey;
       public       postgres    false    1644    1645    2073            e           2606    27758     fornecedorproduto_idproduto_fkey    FK CONSTRAINT �   ALTER TABLE ONLY fornecedorproduto
    ADD CONSTRAINT fornecedorproduto_idproduto_fkey FOREIGN KEY (idproduto) REFERENCES produto(idproduto);
 \   ALTER TABLE ONLY public.fornecedorproduto DROP CONSTRAINT fornecedorproduto_idproduto_fkey;
       public       postgres    false    1657    1645    2099            f           2606    27763 '   fornecedorproduto_idtipofornecedor_fkey    FK CONSTRAINT �   ALTER TABLE ONLY fornecedorproduto
    ADD CONSTRAINT fornecedorproduto_idtipofornecedor_fkey FOREIGN KEY (idtipofornecedor) REFERENCES tipofornecedor(idtipofornecedor);
 c   ALTER TABLE ONLY public.fornecedorproduto DROP CONSTRAINT fornecedorproduto_idtipofornecedor_fkey;
       public       postgres    false    1668    1645    2119            ~           2606    27902    historicopedido_idpedido_fkey    FK CONSTRAINT �   ALTER TABLE ONLY historicopedido
    ADD CONSTRAINT historicopedido_idpedido_fkey FOREIGN KEY (idpedido) REFERENCES pedido(idpedido);
 W   ALTER TABLE ONLY public.historicopedido DROP CONSTRAINT historicopedido_idpedido_fkey;
       public       postgres    false    2129    1713    1715                       2606    27907 %   historicopedido_idsituacaopedido_fkey    FK CONSTRAINT �   ALTER TABLE ONLY historicopedido
    ADD CONSTRAINT historicopedido_idsituacaopedido_fkey FOREIGN KEY (idsituacaopedido) REFERENCES situacaopedido(idsituacaopedido);
 _   ALTER TABLE ONLY public.historicopedido DROP CONSTRAINT historicopedido_idsituacaopedido_fkey;
       public       postgres    false    1715    2127    1711            �           2606    27951 !   iditemavaliacao_iditempedido_fkey    FK CONSTRAINT �   ALTER TABLE ONLY itemavaliacao
    ADD CONSTRAINT iditemavaliacao_iditempedido_fkey FOREIGN KEY (iditempedido) REFERENCES itempedido(iditempedido);
 Y   ALTER TABLE ONLY public.itemavaliacao DROP CONSTRAINT iditemavaliacao_iditempedido_fkey;
       public       postgres    false    2133    1717    1719            �           2606    27956    iditemavaliacao_idmotivo_fkey    FK CONSTRAINT �   ALTER TABLE ONLY itemavaliacao
    ADD CONSTRAINT iditemavaliacao_idmotivo_fkey FOREIGN KEY (idmotivo) REFERENCES motivo(idmotivo);
 U   ALTER TABLE ONLY public.itemavaliacao DROP CONSTRAINT iditemavaliacao_idmotivo_fkey;
       public       postgres    false    1719    2081    1649            �           2606    36194 '   itemavaliacao_idsituacaoitempedido_fkey    FK CONSTRAINT �   ALTER TABLE ONLY itemavaliacao
    ADD CONSTRAINT itemavaliacao_idsituacaoitempedido_fkey FOREIGN KEY (idsituacaoitempedido) REFERENCES situacaoitempedido(idsituacaoitempedido);
 _   ALTER TABLE ONLY public.itemavaliacao DROP CONSTRAINT itemavaliacao_idsituacaoitempedido_fkey;
       public       postgres    false    1722    2139    1719            g           2606    27768    movimento_idoperacao_fkey    FK CONSTRAINT �   ALTER TABLE ONLY movimento
    ADD CONSTRAINT movimento_idoperacao_fkey FOREIGN KEY (idoperacao) REFERENCES operacao(idoperacao);
 M   ALTER TABLE ONLY public.movimento DROP CONSTRAINT movimento_idoperacao_fkey;
       public       postgres    false    1650    2085    1651            h           2606    27773    movimento_idproduto_fkey    FK CONSTRAINT ~   ALTER TABLE ONLY movimento
    ADD CONSTRAINT movimento_idproduto_fkey FOREIGN KEY (idproduto) REFERENCES produto(idproduto);
 L   ALTER TABLE ONLY public.movimento DROP CONSTRAINT movimento_idproduto_fkey;
       public       postgres    false    1650    1657    2099            i           2606    27778    movimento_idunidademedida_fkey    FK CONSTRAINT �   ALTER TABLE ONLY movimento
    ADD CONSTRAINT movimento_idunidademedida_fkey FOREIGN KEY (idunidademedida) REFERENCES unidademedida(idunidademedida);
 R   ALTER TABLE ONLY public.movimento DROP CONSTRAINT movimento_idunidademedida_fkey;
       public       postgres    false    1671    1650    2123            j           2606    27783     ordemproducao_idorigemordem_fkey    FK CONSTRAINT �   ALTER TABLE ONLY ordemproducao
    ADD CONSTRAINT ordemproducao_idorigemordem_fkey FOREIGN KEY (idorigemordem) REFERENCES origemordem(idorigemordem);
 X   ALTER TABLE ONLY public.ordemproducao DROP CONSTRAINT ordemproducao_idorigemordem_fkey;
       public       postgres    false    1654    1652    2091            k           2606    27788    ordemproducao_idrefeicao_fkey    FK CONSTRAINT �   ALTER TABLE ONLY ordemproducao
    ADD CONSTRAINT ordemproducao_idrefeicao_fkey FOREIGN KEY (idrefeicao) REFERENCES refeicao(idrefeicao);
 U   ALTER TABLE ONLY public.ordemproducao DROP CONSTRAINT ordemproducao_idrefeicao_fkey;
       public       postgres    false    1652    1659    2101            l           2606    27793 "   ordemproducao_idsituacaoordem_fkey    FK CONSTRAINT �   ALTER TABLE ONLY ordemproducao
    ADD CONSTRAINT ordemproducao_idsituacaoordem_fkey FOREIGN KEY (idsituacaoordem) REFERENCES situacaoordem(idsituacaoordem);
 Z   ALTER TABLE ONLY public.ordemproducao DROP CONSTRAINT ordemproducao_idsituacaoordem_fkey;
       public       postgres    false    2109    1652    1663            m           2606    27798 !   ordemproduto_idordemproducao_fkey    FK CONSTRAINT �   ALTER TABLE ONLY ordemproduto
    ADD CONSTRAINT ordemproduto_idordemproducao_fkey FOREIGN KEY (idordemproducao) REFERENCES ordemproducao(idordemproducao);
 X   ALTER TABLE ONLY public.ordemproduto DROP CONSTRAINT ordemproduto_idordemproducao_fkey;
       public       postgres    false    1653    1652    2087            n           2606    27803    ordemproduto_idproduto_fkey    FK CONSTRAINT �   ALTER TABLE ONLY ordemproduto
    ADD CONSTRAINT ordemproduto_idproduto_fkey FOREIGN KEY (idproduto) REFERENCES produto(idproduto);
 R   ALTER TABLE ONLY public.ordemproduto DROP CONSTRAINT ordemproduto_idproduto_fkey;
       public       postgres    false    2099    1653    1657            o           2606    27808 !   ordemproduto_idunidademedida_fkey    FK CONSTRAINT �   ALTER TABLE ONLY ordemproduto
    ADD CONSTRAINT ordemproduto_idunidademedida_fkey FOREIGN KEY (idunidademedida) REFERENCES unidademedida(idunidademedida);
 X   ALTER TABLE ONLY public.ordemproduto DROP CONSTRAINT ordemproduto_idunidademedida_fkey;
       public       postgres    false    1671    1653    2123            �           2606    27920    pedidoproduto_idpedido_fkey    FK CONSTRAINT    ALTER TABLE ONLY itempedido
    ADD CONSTRAINT pedidoproduto_idpedido_fkey FOREIGN KEY (idpedido) REFERENCES pedido(idpedido);
 P   ALTER TABLE ONLY public.itempedido DROP CONSTRAINT pedidoproduto_idpedido_fkey;
       public       postgres    false    2129    1713    1717            �           2606    27925    pedidoproduto_idproduto_fkey    FK CONSTRAINT �   ALTER TABLE ONLY itempedido
    ADD CONSTRAINT pedidoproduto_idproduto_fkey FOREIGN KEY (idproduto) REFERENCES produto(idproduto);
 Q   ALTER TABLE ONLY public.itempedido DROP CONSTRAINT pedidoproduto_idproduto_fkey;
       public       postgres    false    1717    2099    1657            �           2606    27930 "   pedidoproduto_idunidademedida_fkey    FK CONSTRAINT �   ALTER TABLE ONLY itempedido
    ADD CONSTRAINT pedidoproduto_idunidademedida_fkey FOREIGN KEY (idunidademedida) REFERENCES unidademedida(idunidademedida);
 W   ALTER TABLE ONLY public.itempedido DROP CONSTRAINT pedidoproduto_idunidademedida_fkey;
       public       postgres    false    1717    1671    2123            p           2606    27813    perfiltela_idbotao_fkey    FK CONSTRAINT x   ALTER TABLE ONLY perfiltela
    ADD CONSTRAINT perfiltela_idbotao_fkey FOREIGN KEY (idbotao) REFERENCES botao(idbotao);
 L   ALTER TABLE ONLY public.perfiltela DROP CONSTRAINT perfiltela_idbotao_fkey;
       public       postgres    false    1632    1656    2049            q           2606    27818    perfiltela_idperfil_fkey    FK CONSTRAINT |   ALTER TABLE ONLY perfiltela
    ADD CONSTRAINT perfiltela_idperfil_fkey FOREIGN KEY (idperfil) REFERENCES perfil(idperfil);
 M   ALTER TABLE ONLY public.perfiltela DROP CONSTRAINT perfiltela_idperfil_fkey;
       public       postgres    false    1655    1656    2093            r           2606    27823    perfiltela_idtela_fkey    FK CONSTRAINT t   ALTER TABLE ONLY perfiltela
    ADD CONSTRAINT perfiltela_idtela_fkey FOREIGN KEY (idtela) REFERENCES tela(idtela);
 K   ALTER TABLE ONLY public.perfiltela DROP CONSTRAINT perfiltela_idtela_fkey;
       public       postgres    false    1665    1656    2111            s           2606    27828 #   produto_idcomposicaocentesimal_fkey    FK CONSTRAINT �   ALTER TABLE ONLY produto
    ADD CONSTRAINT produto_idcomposicaocentesimal_fkey FOREIGN KEY (idcomposicaocentesimal) REFERENCES composicaocentesimal(idcomposicaocentesimal);
 U   ALTER TABLE ONLY public.produto DROP CONSTRAINT produto_idcomposicaocentesimal_fkey;
       public       postgres    false    1637    1657    2057            t           2606    27833    saldoano_idproduto_fkey    FK CONSTRAINT |   ALTER TABLE ONLY saldoano
    ADD CONSTRAINT saldoano_idproduto_fkey FOREIGN KEY (idproduto) REFERENCES produto(idproduto);
 J   ALTER TABLE ONLY public.saldoano DROP CONSTRAINT saldoano_idproduto_fkey;
       public       postgres    false    1657    1660    2099            u           2606    27838    saldodia_idproduto_fkey    FK CONSTRAINT |   ALTER TABLE ONLY saldodia
    ADD CONSTRAINT saldodia_idproduto_fkey FOREIGN KEY (idproduto) REFERENCES produto(idproduto);
 J   ALTER TABLE ONLY public.saldodia DROP CONSTRAINT saldodia_idproduto_fkey;
       public       postgres    false    1657    1661    2099            v           2606    27843    saldodia_idsaldomes_fkey    FK CONSTRAINT �   ALTER TABLE ONLY saldodia
    ADD CONSTRAINT saldodia_idsaldomes_fkey FOREIGN KEY (idsaldomes) REFERENCES saldomes(idsaldomes);
 K   ALTER TABLE ONLY public.saldodia DROP CONSTRAINT saldodia_idsaldomes_fkey;
       public       postgres    false    1662    1661    2107            w           2606    27848    saldomes_idproduto_fkey    FK CONSTRAINT |   ALTER TABLE ONLY saldomes
    ADD CONSTRAINT saldomes_idproduto_fkey FOREIGN KEY (idproduto) REFERENCES produto(idproduto);
 J   ALTER TABLE ONLY public.saldomes DROP CONSTRAINT saldomes_idproduto_fkey;
       public       postgres    false    1657    1662    2099            x           2606    27853    saldomes_idsaldoano_fkey    FK CONSTRAINT �   ALTER TABLE ONLY saldomes
    ADD CONSTRAINT saldomes_idsaldoano_fkey FOREIGN KEY (idsaldoano) REFERENCES saldoano(idsaldoano);
 K   ALTER TABLE ONLY public.saldomes DROP CONSTRAINT saldomes_idsaldoano_fkey;
       public       postgres    false    1660    1662    2103            y           2606    27858    telabotao_idbotao_fkey    FK CONSTRAINT v   ALTER TABLE ONLY telabotao
    ADD CONSTRAINT telabotao_idbotao_fkey FOREIGN KEY (idbotao) REFERENCES botao(idbotao);
 J   ALTER TABLE ONLY public.telabotao DROP CONSTRAINT telabotao_idbotao_fkey;
       public       postgres    false    1632    1666    2049            z           2606    27863    telabotao_idtela_fkey    FK CONSTRAINT r   ALTER TABLE ONLY telabotao
    ADD CONSTRAINT telabotao_idtela_fkey FOREIGN KEY (idtela) REFERENCES tela(idtela);
 I   ALTER TABLE ONLY public.telabotao DROP CONSTRAINT telabotao_idtela_fkey;
       public       postgres    false    1666    2111    1665            {           2606    27868    telefone_idfornecedor_fkey    FK CONSTRAINT �   ALTER TABLE ONLY telefone
    ADD CONSTRAINT telefone_idfornecedor_fkey FOREIGN KEY (idfornecedor) REFERENCES fornecedor(idfornecedor);
 M   ALTER TABLE ONLY public.telefone DROP CONSTRAINT telefone_idfornecedor_fkey;
       public       postgres    false    1644    2073    1667            |           2606    27873    telefone_idtipotelefone_fkey    FK CONSTRAINT �   ALTER TABLE ONLY telefone
    ADD CONSTRAINT telefone_idtipotelefone_fkey FOREIGN KEY (idtipotelefone) REFERENCES tipotelefone(idtipotelefone);
 O   ALTER TABLE ONLY public.telefone DROP CONSTRAINT telefone_idtipotelefone_fkey;
       public       postgres    false    2121    1669    1667            �     x����r�6���S�j�Ah�%�tZ���q�K.��L)�%iO'����w� %~� m�C۲��o���/B����Z���Lb��3ee�ߣ�D��)�6׋/��䤍/k/��w�N�JS��󓘞%�4�����{�[]�;ۀ�E}���N!ޢxIL�-ҭΣ�N+�֚�N���6jL�:[��j0��s�QP�k�`<+������n(_=%i��� O��4$٧���
��E���;}��u"ؿ�-\<��5���˕��W��*��v�f&�u2��ef2�'C���Hۀ0�d�O�F�)��ɴ�\��W|@�ZT��.Mi�y�lN��dCi���b��Ҡ���%aP��%�|�o�[��ʡ@�E��p������n��cS�`��VM����I�5@Ș���ɌHK��P����!#x6ri�X $T� �6� �c�31�=n1fP��g�s��9o1�"����yVH<�01�:C[� ��k�ݚ�ೡ=�a!��y�R9�h��P@�l��K"��<^b
	����:VF�b��1� Hլ3A���|���m&�ѻt��U���qL@F�����0�w8�p�^A�Ĭw7�)��\����<����*�`&!�٬����߼�	� �m7�bv����Q����hr	q,g�f�� F�3����9k߄DF}�Xr2�Z�g���1��2�}�1�w�_�t[��F������!��#�&��E�cC��k�]�`��/)�H�[�b㆞zޏ=CK�!%�N�)_dS�߉8�El�� u"���ئ����_d��:`��E6-Co����"�:��u���{"N�1H�8�|ol���2�5f�,.|
uc���h�=�����vu��G� ��vx�	����az�fPb�ޛ&��K3�%��V�L���~��U]��~��l!���c�i��N77��F���Meœ=��*}��A��B��%w�_���yR�Jl�;���K�8��(7ׅ�x㥍�ޕM$1��i*���(0q�Wi�����O�4щٛ��\XX����C(�_	�R�;t��y���Fs��t���ϋ�V1��ʪ��.�- �lgB9��O���GS T � d
���e@�1���P�9Ar[_�$	$�I��jRL�̯i��i1�]�%"B�!��q��18o�yyq��b�f>70�~�ɫ�B���uV�}6�m�L֡u��6l�����3��ot���>�'7��#�1E��l0�<z,��ʛ��7{��h-
|� ���^o�      �   =   x�KL)NKL+N�44�J,NIK,NK�45�rvqaN#.��!����5����� �>h      �   �   x�]�K
�0���)���؅Wn��(�4��Qz_^ä���|3���d#�ht�U�BG��i�FO��C�=���Z�#��f��ؘ��3�
�]��O�čM�e�P`g�A�!��,���Q{�{1�-M��1'"te
�S�mx�\��e;�8��W��a-�I��>���JJ�b'h�      �       x�3�420��54�50�460�4����� 1��      �      x�3�4�2�4����� ��      �   �   x�m��N�0E뙯�,�yP�iA@I3�����l��_P��A�i�]�AA[�5���nأ���Ʃ�c���Q/��鱅�T��sa�Y�S�	��:X����M۝Vm��E:k�''���ufˁ�(�B:��L�?T4����$�S�F&1蚅Xt-\�GyRga;̦���9��H�����������`]�>.��D��r]Z      �   K   x����	�@B��0AC:E'���(\��(�@| 
��g�D:IK�t��U�h=��N�uPY�㍻��p /��,G      �   �   x����
1D뻯�R��V�	~���r7���l��w-����:000�7��_Y����E�8\K��n��oӮ;�RA�X�jb�#��+S��
����m����RH1�qt�(C[�e�e�G�8��ˀ���I�M�曪:'�����e�����4AGKsf�o�M}߿�?\"      �   G   x�]���@�P�9K,�������E&PJP⹸"�������ז�����r��2L������      �   W   x�3�LK,NIKq(�z v1�9�1g"���r-8���K2��J�r�J2�R��s3s���s9-�,9�RR�rJ3�$b���� �b �      �   �   x���1�0Eg�^Y*�m qF�4j��V$�ʹ%aA��,�~rܸ�0^��È�M�ZF�8́q�Y(*�~IQB	��k����$xǽ5ѱ�FGg!��>����X睭J�����,�D�������x�ٰ��3�"�p�-5=e��Fr*�w` W5      �   L   x�m�A
�0��ǔd�����0�T��2�I���F�� "��a����#��1h�
CN[e��J�1E_��E���U      �   `   x�3�L,NI�,�2�,NLIK,�M��0̙�e
 ɥ@pJZ1L�)%��:�Pt�$��朆F��(f��Z�8�$_!)1/�aQf>О=... ��.      �      x������ � �      �   �  x�m��r�0�g�)��a@���^;t�ҎY� m���^_�C^��E�	$c��l�"�'>Xh��:Tk"��>���ƕ8s���Alb��,J�nF�����7���X��S6�5w�A��q�I���A���0s����=�����/�@U����>.��ÙߦR�B��qNŞv�y�ft�ө9��0���4�(�!Y��T�y^��������w\ ��0b�U]�Յ�.+.U	Ia`�T~y����ph"(.�jyj��f���1��H���,���E�a)B�4B&�<%� @Z��ҴG:�-@�g86o���Q%�����_}S�:R����wIā��FÕ*��fM�����r���n�L-�v�=N�����F���1�
d��      �   Q   x�-���0�s��,��?�@=�$`��`Q�@ȑ2\�p<|��.E��+����R�y��u�ƫ��_�ئ/"� ���      �   :   x�eɱ !�:�� ��Y�D͵�?�Car��~��{��`����94�����      �      x������ � �      �      x�31�42��440�300�4����� +"b      �      x�u�;�.���k�ӊ݁]A������rN�92��q	0�f�X�����$8����w��n���i��P�w�?���������i:�?��(J����ۤ������W%�����S7J�?}�l��~����L�ٞ��RE����i����g���A�Wr��g%<������g���(Z��7��!�����,�����ӻ�<��~6Ϥ�J)���>��Q8�i�G��`@)��ҟ���`d������>"$#�<����v�����G�pL�8�J�s�gT<_�����2��8�'J~�鸒����b����\��k~��(�������;~^���~h��#��� �G��GN�Ǐ��ƟWyT�*����ȝ��?��$�B�y>n�I��s櫟��G�T�H��ϛ����Y�G��t\H�~��G�w���"�G�FF��E�@崟��ghU�ϯp�j[�#*��R�ߓ��z8�����g*�v�<?3�QI��|f��I�r��[�s�����i�3W~���,$�,$�%�$�a[�����<2�amgl�q)��}����i#!�̇���nK�H2��\�2̈́�Wfo�g���kFdk��?�&���L�ּ3��t����\t�	j�y$�Qds����V$$���LcS����ΔI�������b��VE>GIg��N1G��GϏ�?3#�Gm����W~T#С'S�ɓ� ��B��*�r�Р�*����ϼ�����PT��4?s��̙|FQK�ј�X{~��j$� ���.�C����?ܳѶw���H�|��ī�YN�j"�#<A���D@g9��g|��#�����ypL�s�]�uv�s�Q�W��g�Lx��v��� К��YN(юr|���Z�����,�:*�E�ߐ�����OY+?�Qy�3������8��R|9�������/���5Qi��O�Ϥ~T+�����(x!�3�ic�7��Ή7�B1��ҏj#���<kl�c�I�Y�-�Q�L����\;�������#���t�Fi�ڙ��|��?|����#w�7v�������g<�������ZC��;��E2Y땔(?�*ٙXg�ƙ�q%=�l䚠rXPƒ]��(=�I�Ho����w|?6��YI��[��SH���3� A���������(������Y�ZCk�wDe!�`o��-m�����j��X�9�-��a��]K������0Y(��&��	������{bu�$'�z���Y�(={���SCٲ0v��A�2��?��(��[�A�o�TĨd[a��)�b_9[��MF�Ky�t��(���ǖ���S��2(6���}jŶ�=+m��O�d�A��F�� gX��]����Hϧ��(�L��֑� ' FZg�p�& S1�RW�C�W���у���\n6�h�J
ԣ���	�#]��z�&��W=�m?�u��<���[��zt�w5�I��/ZW��k�C5Y�^��9B��lpio�2C$գݠ�r�0���o�g�j��Õ��R�1�ˢ��JOx���6H���k��1ЅZ���N�|�(�b�[��ã����g�@tEX�3�j]��Y>8Za��΅�K<A7]֙���0����_pF#����� �}V����Ȱ��Y��ixdX�>�3�</��&V�	��(B#�r�Y���ﲑauߗ�k���a�T����S�ldX�>�6�m���a��滾~�H�|�!�5��ӻZ((��̳�ڒ��J.�yvw�h1Z�+�H�h�]�ߧ��k����B�+��t�܆{��L\��O���`M<R2{0'Lj�-/�w⑮���fXÖ��j�o]��0?�L����e+�Ͼ#Ǖi�8Ȼ�J3��N�x��_i�5콞�8ƣ&[�������i�' �!��У�ִ-��b���|����v�5��`��;Ú6J:�v�ΰ\��-;Ú~6��J�3����e�Zq�ΰ�m�[���˥g�JO=��aM���ljH�7z�^�!-���jH�~�%���<��}5�E� >jH�H� ��ɨ!-�c}��!�#=�7&����N���{���N8d8>�H�����:Ҳ�fzMկi���&B.i�Y���:Ҳ3��nv�3~9�!�#eB�:��f),�ԑ���Y1%�Ȩ#-�C�H�H�w��>u�!BZjNg1i����"ψ@ZjNg~"�:;]^1�0���q��OER�����|�b�eR�R�ڂ�j��msePf_ڱ?Dx��z� L\�j=����m6����&����+��A�>�U�7p�\:�ԏ�C�o2|�Z=�"$���:��!	��ֈ@�pݞ;�p�I����3)f6��u[nW+�ɰ�Y(}k�T$��+m\�`��j�)T�������Y]�*^�fV.���7/ɤ��v�K�ߪ��~���yd\���!6�Pp�9�q�d2
��#���Rp�Jw�eLF�x���Y��UJ�ό�^�Vp�G"=/B��Ur̥2S�Q�}�qH0�G�q����4A�K�`���z��zX����\p�J<;��J�������@V�3�x4�������!��DXGz� 쉴N�t>�B��,f*<g�HK����H���g`+ߞHi����9M�e�6�f�#���lX�{��iyr���@��=�����iuORYE(�2-�_��$��UGE+�r�\qu[V7_�q<�6�˥�wd��a���T�&���V��c�cWf�m�O�LFYY��F[��������h#+;t�`��FTv��c���h#+[���.Xٲ�VLEQ���L��mD%l?�-Q	���h#+uo6����YY��&��Y������n��%���ay����d�2��T�)gV�K�O�[�E���S�M�-â7p���������}�8�eX.=AK�67�%��
'D���揸˲'rGXꛌ����#��9i���Y1N��|�HK=���dq>�!,S��r�m���֢�;²�늱�ɸ#,�<38x㎰�ΥSLƽ����a�}�9��dL�KmX�a�?�qŸ�dL�K�Ȓbʴ<��\��[ϧE��ͽh�2eZlgd�!~��MƔi���$���L릐K<x2S��ҿ��穌�nmNȝ4s�%n�.���3-�$�s�������Ɯi��B��Wpd̙�%�Z�
�,s�%���?�p�%�P��LƜa�T;������A�o5K�%~�EŌ!�r�;\��²t-jfa���r�LƂ��Q9�� ,��0���`l���脌)�eE=(��aY6k� �a��xX�SդKn-̮���a�<2åZ$+08����X�J�z0NhL��`����b�C��3AM��`�S5��68W:�Gpd���^.�a��L�"�d�K���L�0ԓ�&NC`a����,�V,[^�T�����s���P?Q�\\æk[�C٩��Zn��`�I���`�&ͬƳ#�	��lם��O�W8�5��q��;�h�U�X�l2cx���m�Ã��M�`_\����b��s���&c�/�sL�O�bx
L洩싫�h�0��Γ��O=��}a	 vD��u�����<�q�/�>�j8��aRO���2���1�43D�G�ٿ��̖�H$��T�m
�&�l`�a�'w�Ė���qu=2�ƕZ1g�X��q���ƟzB�l`X)��X:*������'l���-~<�g� �{q1$%����{�?nܷHv/nd[�?2�d��JO�i����z����7�d��*Ϸ�d��J�p�K�d�݋[0yf 8���^��6�a^3�d��fX�8�$�7k��!��ߨ�f!����#ѻЧ�FS,$z�4�hi/f2���+�z�|6!ѻx�)�c�L�y�\آ͋7���0P:��[�`2��>�3U�t�Ef��^H:����!��6Q��b[31QGi�1��% ������	�-�:�'B��@l%���}��Nzv�Q#��N�(3�    M&�`�m��k��n���i�;�ؤ��u�g`�7��RO�iBߧ�i����i���bA�x�~�Y+%�sY?���~�@x���xVR���!"ѻ�����75�D�b�S�6@��ŕz�J����C�.���K�vA�uq���[\�օKm��l�d��_�.��h]�˲37.>��]���׎�r� ѻO�%���*��,gLɰ��.p%��ֺ�f���=�ഉfZ��G&ʹ�)��XH3-K�����D3-�aN�E3-+�+�gD3-�4̉N�h�u�rG�hi��� �ddZlc�,/���L�����N�edZ�+E+^�@Zj��3����N&���l�� ���|�����$��T�2�{1��mG�d݋Wj��0gE�b>�9$�4�L�{�JU�m��^�7ʣ�!2�D��rq�'ѽx�6|3%L&Ѿ�OӏVd��DZ�>�A�S����$c��%iY�{*y7�L�e�죘]Ҳ�������eR�u���|DVAKa�n2Y-ϭw^�"������|�(֭����8.�G%a�\Ș�"a��ma�yT�+[�}���u7��\���n2ٽ�2?uH�������d'VD^�S$m��Z�e:�1�l�U���d�JjK�7q�d�'J�,	���Pʾ���ʰțHL�5���JG<(�[[�e��l\m�a���d�{��WiCV�D8s1�6d�����Td�J�M�Y�#B��!+��{XY���^@pfL�a��X�jGX��&�d���j�l�hGXv:�1m�dڑ�E�	�HK=�f홖w���[h��3-� �hH{��Ԣ7c2���.��R��k.�2�R��RK���]J��M��?a2�L���Ύ�R&�vH��U�Iy�*�A	IYs���A	I�;p쩄�n�!�+RBR�Ǟ�x�d�HJ��2��+#(�e����컞�)VFPV�"�k��z%(����Dؔ2�L���X��8q��h`����Ց~O]M���p)ߟ
s`40֓�)l6�Fc=Y���5�1-�񻶛L�����o5����c����1���l�nU*�����=I5��@����P��J�>�ő��J��9��F��s�Q��T[%�]t�쨼�
�@J��!!�d�R�~���Wͬ�;�g��T��[����"+o���&SEX�
n�U��գH(�0�*���_p��J����z +��ԲѤY�̗Pca2�J��6�:��eV&�d:����A������bP9�#���U�%CGf����@42,7���9יay3U3�P�a�Ϥ�X�g�单,��g�勠�$�C3+���U�U��z2Ŏ�F��̰\�O<tfX��`�l��̰�o)���Lg��R+r�6���[4�݊}����F��kx^%��ʬ����&ӕa�yX԰�S#��ʠ��}�t!(�ܥ-��t!(��E��bO���&Ӎ��[C�g��mw�G�A�f��%�I1yZ���n�\�QЍ��?#�S�]�{*^�3��t����i4-�K�'e��ԍR�waG6�kA�=
g�Oe���{�]�	��g(�f5����.�ލ�Z�{�p�Q0��ů���Gp-���,�S��o�t{�"��JK?m�`ZP{�O��^�處��xm|���3*ؚ`�����&i��Q�Њ���3+����{S��Q������3*���k���{<�c�gV��I$�nM6:��Qv_���g�c!�ʰ,K���7(âx|�fX�)��d�2,��q���L��������L��Mu�2-?tn����eZ.=A3dʴ�v����δ\*�FX�d��`�Ż� ��,C`�����r*[\�M6Y�$܋q��Jܶ��M6Y����FVz�^�q��J�t�d�7W9�def��N�AV�c%g�ɨnc�	㐌ʋ�,b�7%�Wx����R=�eT����2HF�f,�\�lHB���B���!	���v�7���Ui"e����MԎ2��&b:�<�O�m�od��W�E+�<����uL5�eaJ�/����ŕ>�j6�F�,鰿
L�<�G�gw�I��J�z}�Ci��`Z<R���wL�G�-�a���Ȱ�������1F��#��Ƞ�V�^�kcdR.5#��_1��[��x5F&ž�s�Ƞ�b�R�H���Ayj�acfP~�N/zB��A��-3���A���pf2&��3���aL���SS�",v{cЉ�����ߊ�n���&Ҳ�kE~ژH˖��<r,�%~��Vc!-�>�1\<����m��e}!-�s/���BZv]�.���n�*���R���~�HK=�+��l,�eE`Z��i�o���3-�r5v�e#�/>��l�L˥vt�δ�&I��L6�oA�5z/��o �Wz��&���[<R-��|�G:>�)_�B���¥ &��x�����mz�u�eG�wF�o`F��J�S��2J}�
I��eV�Mbq(<[f�]
�5
��2��a�D7t��jy���l��q���-�ZO�:��=�Z�.�O�=�r����;VL6{�u��s~b��T��a�j{_���������=���;�S��3�m��0ΞIm���	�=��n�u��2)���u~(ePޢ���}R�R-./��am�B+9&!,�\xq���|E��I���7�퓐����Be�I�y�+��ß6*��Q9��P�S%|��+�v�B'H�K������&��ߟ׵�Rq��kY�l�VR;>�ɚG%U�+��O�����S�|�䌖ů���������=�7-�+�c��M 0ٌ�?-��R�<[D��*oY��ѳ�R�UWѴ����<��i�R�LtB�<��gq��e���BT��Q��2*�M����L�SS�R����yƱ�5�߿fR���}��fT�oj9	;�*ͨ<5T���fT�X��Ҍ�M+���fV����$�ȦfX.�� �.4úҕ��#��i�M�]
��L˷�VZ��ȴ�%Rւ8��i�-R��t12-ߺ�Ic��fZ^�c�B�70V��8��eݒ���@X��ϗ�8�9�n��e�������DXVH�p��z�[�x*�bo��`�	����.���T�s��<�ͩ(���p�0-/��e�D�g]��j��;�an��ǻ�HW��\T���Q�E
xE�"����Z���b����ʰ�i���\�x�E1l]�_"�zY�ֽ<dDO�dseZ.�¾�+�O�Ih�d��3-Ob!�1w�eW#ۄ���ΰ�{���DsgXӏ��ظ���1�1��dsgX~Ǆ�4AԲ3��{�qVfV�J�6�1sgVӓC*;`gV~���pknˬ���j���ťk�eX����z��}+�L�Zf�Jƍ�j�zڇ��d�eT�o�N0Vˬ\*��\���Xћw�«m�z���m��[%5?$O�w���RnL�:UR-�IWg���NL��TR����J/= �g�QI��bA��>+�
WGXݛ��OEV��{�!��M2�ݖL�Q�[	?!��U�=Z���r��	�l��k�0�r�����yj�E�Jܑ���y!�~�o3����Ê�ŕ��k�{��{���xƌ���^�6�-z8�h_�Mm����%h����D�W�݋�������N3�!fYѽ�w�S4Xѽ�R������2��/ΰn���gq��}ZቒA�3W����ʏQ����$��g��M�$��[�"1aI&�[<EKl	�:a{g<�_���GA�WL�Au���%���Z,APt���8_�",oN��R��R1��dKy	�-EX��",KΒX}b���V�mĊ��K-+��E ���l鬤���_�P�g-�N�dK7J�2|�h �^�*@M�FGi�Q�UR�؜�dkp%��%��TA��z��ȴ�]c�p���h��Ƴu����>	����X���n�-��VVST��@jW-�t
���+)5�kJի�a͞�R?��Ph
J�˚lE��v�lI�h^�=�t��ˊ��U�! �+�W:�[�V4/���0GbE�B�rɾ0IuE���yV峮h^��k�%��y��E;��y�餆�e!+����=�BX�x�t��i�    ��(fוi�-F�}�V�՟�*8u_;Ӻ�V��δ<Wݲ��'I&[;�r�9x�����2S���aݻc���3���.�����ΰ��X������b��a�`��ʪ�������޻��SwCX��QHi2�n�����i�g���f�톴���e�L���^�v˴��[ ��-�"�W�F�d�eZ.墁�n��K��}|���y�_� �=ӲZ�����5��l�l�L˥T4��=�"��];�/@��`w��^_3��HK���}w�%~�+��HK��t16eZ��Ң�mS��ϝ�pP�)���$*��i����]�p�2-��)��Iy�/�{�M��,���Y�mʤ\��Ѧ��S��m���@qC����ZM���Q��W!Mg3�T����=3*�*�7J=�1x�&۬���+7'T��%�'J}O��M�9�R�e����jxV��%�ޠ���%���\ dؒY�e��Aޖ�j� (�vؒY���Iػ�lKf��3���/���>CE%���/��g[2��Q�Z�-�Uj�W2�֌j>��!�jkF�Rk����lkf�Rk3�Z3����w�ɶfX.�}���|VV�+ޚa���v����fX~�f'N0�a�Ղ;�����=H+�a�kWqa��7���d{ ,k_���7^q��˒��&�=���1����-<�U�Y��x_�@T��sT"*�*����d{"*kh[�,�h]L�+��0���|k��1��vt.����fG�b>�dkѿjG��J��������|�梁֎�ŕz�h8��ѻ��5�$E�����)��]\)��({eX�q�a��W�E�]�b\-F��㼲���p�KAz�aHR�ѺXO�S�U�u�.�f[ҋ!�����o�> Z�i�o�`���sq;x�1���\�ǽR�IuG����uBF��vt.�{K�.kt.�Ӻ�lq����r�Ɵ� vf�R�/���ά�uҊexgV���ά�_��f�O��eZ^�ߊ��6�r��B��dm��3^B��յ����Z���h33/�'|���25zn��S�����m|���G���$�bE<���VGi�[x.ZI��38/#/��4s�7�Ί[���Y@ �h36?>�'|iG���W�u�h35~�\�ᮮ��튋D����n���z���������\]�?i��F����}#��QFw�**�W<ڌ�YtG�ѱ��<�4W�(�s�,�j:���v��,;ځZ��,��k4A,�vwG�*��sܫk���@���2�JK�E�յhs징&���j���:ZF��-�'����!]��Z4;��3�`�q��Ҫ�ܶ�k���O{w*���v�v�5?ӵhyl/w�<g����籟�Ŗ��X:O��v�`B�����o`���Sr���~�q����x�����C��յ`~\1{N�G;���ҷ<O����?���t��৚'�: �V�*�������v���Y��v���v�[�k��j-�=�������+�C&\o�� �������*j��[4�v�vr�~�}s���X����6�S_�f�KueM38�J�M�������2�����i|���fp�T����Ի�b?�#En��J�Ϯ�g�hq���fp�S��ґflӏ;6l��4Ss_��*����#�Y�3S�O3쵎6S�~� �m�6�*��0=�L͵�yB3]����&[?F��������ӵ9*�ykՃ'h�{�s��-Ъ�D#o��vG�Mh�WC.��m5�n��꠽݋��P�ߐ.x�A˾��\�y��[��Q�R�����\Wx�	ۭ�}Ɵ;A۽ÇL|�B�_����1][��ϓv	|p;cSO���7�M��K��vƦ�Z�qJ��>�&-�s�k;s�s�V[�fm4��5׷-r��i����+�9�C-r���cg#�{1���r���s��r���y�u�!8�8?���.!Bs]oN�:��zCr������ѩ�8�������i�Ctzz������3�}�����y�l�zz����3��{7�$�oZ����ɍ��Y��n�U������y���mXz�؆w�?&��3����͸���=_l�b�h3��~z�1딱ݘ簠��\��M�W�;�Ã3��/�τy�S�G�b�>7��r9�P_er~zh'bS�g_et.>o�q��G}�htBr�Ipǹ����kB��ɩ'v?��Ǳ���m�Y�aFr�F�C�u����U�bDw��N$>X��N}�4���BO:#9�޺;�i���,f�kxxp@��Z�X+��.��o/�3���Wb�¿N(j��_ۚw��`C'�b�V��_��#�VQ���Q���ɨ�v7�K�(��R�{tN��oC� �K"׽���F¿�ז9m�ز�q��Z��4���kFw����VE���}y��P�u��\l��b�����"�4���ѱw��U죙��@q�$��#2;/l`-�|��nu�|1��^C72:�k��#����bE������^̭#��h�vֹ���fp����c��C��x�������'�������N�'J#��|�[�/-��@��-e��xN�q��g7|��?\�>38�D�e1����><�v�u}fr.�bN=3��^E��>�t}ft.�KM��Ln>]�7�����mt=3�����6�'򖒌�$�G��+������%��EUxߣ}�Z'��ף}r���?�^MZ�;�"����@���sk��y���S��=(W{+L��+���W�w&�b]X�s��=mA ��h39���v'G������8~�;�s���5��oDǾ|��G�H��XWX�M�7��ɧ��:ZD�~�������f��)���y����,��ZF�bi�9"��ε��ܫ�h��&B��Ee=�/�"{�h�V����:��~
����>�	�̄ˤ������;��v`G�D���7m�J٫�`�t�{5�L
.ʯ�N��t�W��8�`��;�zvh+~�D-�2%*�E(�(��j������`�<�O�
#�Ѫ�?������E�X��()�b):w
F���Ym���h;h�{�Ĭ�Q0R���`��aG�ȑ�{��ӣ��n/�]��L��� �h38��P��m�F_=eh�fԊ�b����>e��؉32oHϫXi�32�DҢi��fbޭ������W:BA��"2���X�}�����J��c:
ʯ��=q��j���R��((�bk`[D
ʣ�)
:�t
J����̢����J��X�{uj���xv,�`�����J����^�8E-y�/|@�=y�|Ө�'LԪj`0P�O���{���/7�'��H���<Z�ZF��;ڎZ����z�yr������Ak8���Բ{op E�;y��߃ �`�<Z���-|�D�W-w�LR�N�mS����K�Hi 6�;�燁�,j�)�fu8�G���&^����f7b�a�	�f�Dδ��&^kN��@l��{�O8a����L�S����x��"d���N�Bī��A��O�`�B�P�Ia�MF����:4�~��gi&p7(��ț�9@۽��hN�z�q�-�����FZ-o3s�,��PvZ?�A�ǣ���J-��=�L�� ��V��[�o���Q�M�I��7�!j�M��ε[�'��_�L�̮�`�<��o�"ܵ��W�7��}�m�o��
)�N�M�m@�Q���1џ�eB�D�'(��`����K֏43���j����"ݎ�_b��o.5i��G�-Q�n�`�<�����F��n"�ܒ+����{�`�<Z�Q�I��Yr���+|.^ɣ�� �xG+��W�A5 ���n[�0��خ��ظ!6��|���=� �Jn���~sGn��˿e�W�=q#�,��غq'���(h�p�IH^��(�<Z�y\�Y�l�+���p��%�Z;֯6�\�G��]��-�z;\U8�$��V�D��$��ˠ��Ƙ�j}v�y�5�x�+��ձJ%�]��*j= Vm�R��k���|k��҅Z��Z�^�F�zKp�xd�ޛ��tu���ns��72����n<��������8��ߖ{����� A	  ���	b�a��	~�z�]��Y��;ۨ��a�İ^��Q���9F�W����v�cT��,
?Z�͖
5�W�1��g�3e�v{���z}ҝ�~ng�{-�x.��}�8��ܠo=S���yW9o�[,^�^�SD&�@{�C���e�Z�XQ��KP�=Y
�T^��5�T�{h�]aPz}�����{���gkk��αˏhgnw�;��ޙ���b{�#��n]Ѯ�h3��zb���ƿ����j�vo�д�HG)�y�0��~���c����jo�Q�m�7�ȿWbl?ޑS�K��]˞8�[c������xgc����"m��#�|m�I���.r�6s��&��HDb�v7\�����v�F�H��e�K�s;bS�W� ���n�t0�gj�©*�������{wE�fh�[�34�Z#��e�W'=Ss�m��6S��zzA�%=Sc���#�����2��ja��2�7��(U��I�8B��Z��R���w����?���M���$�>���6���Zo�8x��ղ{��߶A+~%:z�Ai����u��C�PH8�|�7��	'�^��9�g��?��6�ߛ��N�(��`���J8��Z���H8�|��Gc�^��w*��?���a����G{{�B�,�����4A�cU	����k��,�~>Z/E�xZ��磝u����ϫ�Q�[c	ǟ���W�p��h��E�?���X,W���j=x�{8�|��Y��B�=י�7���^x�Ck׉&p�5���!* ��Z��'����� �t��`R��A6�~-}Vˊ.��1Ī�Aݠ�T���b���)�V<�4�E��%�Zo�nq�:�8%�����㔼Z�����S��ޭ1��u��J>�j�&��W�0cG>6ɫ�	�z�B����A�|l�_�wxÑ3���	���&BS�F�j~����FV�Z=���[��!.33�^�\�y���-U�,s�Y{ҡ4S������43�����5dj�wb��wY[�ĥʌ���y�7�ROd!6�{��ː���/S/���؞&Q8�b�
��Bl�������^wo-r�t�#���,%�:��������Fnzuq>��Mo�%�6r�-e�_����W�V���3�7i���w�F>��������0w�xn���G�N�dgn^BЊ�&����f�Wom�v3�x��27����cm��wl}��oӆ���b�]hCn�����Ԇ���zȍg}D��Y�ː6�v��Z��#��  �!��M���V����A���M��V홚�4B�I�i����bŭ�����3��q����^�%Z���j=��}��]i�r�j��
_u���0�*h����.o�SJ�Z�{�����Z����������8?V�HW����U���2��xW�!s�OW:��3����im�v;{�6s��Z_��U��n7x-�T��{@���ޔ3�iK�mopZ�m��r:�m>%r�*gl�ۙ�bmƶ�Eѓ��dn��,W�&��m�C�@�,�ܖW��V*������P�ؖ�`Q��Jƶ|լN�T2��Id����-�h��)Q����aO?U�m�XEl��T���T!V�&��*J�]��hx�"5�mƒ���w^��9�L�&S?qC�m���
�H5S�6l�­ڶ"^ŮT�Mb��\Βf�įk���4�$���N��k�H,?�̤��R��i��N��EB���z�lQ�e��nN�(���ݛ�[qq��nЊW>�0�6	����"��6�7��	��6�=%�ʸ�l��SR{��e��<贼�~�Mr�,ʖ��m�ۡ�<o��<uv��!G���s�i�d�����!�}���n�1�"�$OQܨb���<u��N4�$7[�� �h37?��%�쓘�3�E�I�y����$�$��]2pe�>	=�W��h��c}hqgh�h��c}��[,��&���X��F��ܢ�+�%(�$W����mz������{,W�^�I�I����Mr����.#s;�`�yy�M��g��˭�f��2/��WIԣ!/�DM��!/�)���.?K��V?WA�m���F���]�"G����"��]�U߶�OH������GO�l#J�xG��yO)/�
g%��@l��0�GO�����G���*
�����SWd�����X֤��glާ�����r��^U�Y�gnޝ�,j� �ܬ
�v�����-�˔�sPƶ<Ѣ�Q�h3��M�S4(S[��V�ă2�巡T�����cDUߠ	Z����%l7�����H�[�vB'�67�z5+ZD�;h�֝*�n0�v�V��2j�)�S�Z�pq���*j��P�ͽ����_��_�?.�6      �   ~  x����n�0�g�)� �%�\�MA�d��(��³�
[�P���A� :]:�������Ͳ�Q?~$]��7!BX�[c��N�9���|s�l�3X.y�� ��K	jF!�`)&��43u57�(��z�����̫Cs�fb쁘�*�)� �k�_�z�a�\~�����0��4 ��yKK<D9P�J��(�K��iD8�����t���=�m����"��A�;1�
��d��Ō�{Ԓ�Quj>��$�eR�5���}tr� y
!H�ɽ��d�3������9�{�c��>0S��#�"��%.��@I��6��vE?����$��jp87������I�/xb�`Db�`����Q.��=�_=q�*QGm�$J�u��\��2����"*�B���UH�W��RR2�[Tr$p2���#�ȤY6˴�7�8���k��c�!}T�[ֹk��|��-�E}bn�j�2�1;�:�)��b\'���orH��7�	x�(ũ��u������.N��%��Er&$��٠�֥{�^6Q�K���#�9��[�mM�j����f���wWC�Nk��{K5��\�L���nI����°a���G�);��M���UU��7��      �   }   x�=L�
�0<o�b?@<)�1{��L�V�[Ҵ�~�)Z�y,;��6ֻ?�]�qԙ#��s�:��3�2� |GV#�gZ�/tM-z�$��3��'��<dS��8H�$�Ï�1�=�0j      �      x������ � �      �   #   x�3�t�+)JLI�4�2�N|d�r��qqq p��      �      x������ � �      �      x������ � �      �   #   x�3��M�+M��2�t,-��M,�LN����� q�      �      x�32�4��420��"C3�=... +�      �   �   x�}��
�0��_��'��N��&z�Rh�p���d���%_�lrA��x�C�O��U�Z�9ü+��\3װ��o?ifv7��_RŤB��_Tǔ��S��4�D{ +j$6�{Ŏ�u��C���o�F��5IT�������ٴ\p_+�>�^T�      �   �   x�5�ۑ�0C�����y8����XY����D�p)�Eui�'յ�6�t�=4�S�-	������B-�R-��x5�{=�W�!<���C�������˹n�d�F��[-k<d����M����1�;�}(�6R�-މoW�7T7�7��,�W�X��!�0�>;�}�ZC�xp�Fn2�����	�7o      �   �   x�m�1�0E���DI�Ў]�q�.����r�&8B u����l�� �q�O���W�����ѠEKW��̡��*���2��K=�R�p�n���O�fgφS���SzY�����b4j\��>݇)켷z���x}�0D�q�48      �      x�3�t���������  ��      �   !   x��0�420��4�300@! �%W� ��n      �   *   x�341�420��"C3N=�� J�sZr��qqq �ne      �   "   x�344��0�4�300@! �%W� ��~      �   6   x�3�JM�+�LL��2�tJ̬ ��9�K�R�3N�ļ���D� �^�      �   +   x�3�tLJ-*I�2�JM�ɬJLI�2�tN�KN��c���� ۫
�      �   B   x�3�tLJ-*��2�t�+�LL��2�H,J�L��M�+IUpJ̬ 	�p�X��Ήyɩ9 v� ��	      �   �   x�e��
�0E��~�Pq�ev�"]�y��)�M��m�Ԟչ�2����.�h���0.a�um�P����L�
;i��P��>��j�2�,�pv�[5��p1�S��U����KD��tM��:#�\+S=      �   H   x����0���0�3!I�K���j?�a0Q�M���҂'ڬS����3�t8��A|������/      �   3   x���  ���0��q�9T.�G"��@�ǒ}��Kx��ځ���R�      �   (   x�3�)JL�L���K��2�t�M-JO�K�L����� ��	�      �   -   x�3�J-�LI�K�L��2�t��M-��9�SsJs��b���� B2      �      x��**��4����� ��      �   5   x�3�����O/J�M�L�.sNw���L������L����p��qqq ݥ�      �   l   x�3�41�42�tI-N�+��)KM�/RH�W�,.I�M�,�L���L�KI-�)ͬ�2�4�44����K,�H�SI�SHIUpN,J�J���AtqgxVQI.W� b6+�     
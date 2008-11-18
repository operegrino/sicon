PGDMP
     	    3            
    l           tcc    8.3.0    8.3.0 �   �           0    0    ENCODING    ENCODING !   SET client_encoding = 'WIN1252';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS )   SET standard_conforming_strings = 'off';
                       false            �           1262    27333    tcc    DATABASE D   CREATE DATABASE tcc WITH TEMPLATE = template0 ENCODING = 'WIN1252';
    DROP DATABASE tcc;
             postgres    false                        2615    2200    public    SCHEMA    CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �           0    0    SCHEMA public    COMMENT 6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    6            �           0    0    public    ACL �   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                  postgres    false    6            �           2612    27336    plpgsql    PROCEDURAL LANGUAGE $   CREATE PROCEDURAL LANGUAGE plpgsql;
 "   DROP PROCEDURAL LANGUAGE plpgsql;
             postgres    false            j           1259    27337 	   auditoria    TABLE /  CREATE TABLE auditoria (
    idauditoria integer NOT NULL,
    dataoperacao timestamp with time zone NOT NULL,
    log character varying(10) NOT NULL,
    operacao character varying(50) NOT NULL,
    dados character varying(10000) NOT NULL,
    tabela character varying(50),
    idreferencia integer
);
    DROP TABLE public.auditoria;
       public         postgres    false    6            k           1259    27343    banco    TABLE _   CREATE TABLE banco (
    nome character varying(100) NOT NULL,
    idbanco integer NOT NULL
);
    DROP TABLE public.banco;
       public         postgres    false    6            l           1259    27346    botao    TABLE �   CREATE TABLE botao (
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
       public       postgres    false    6    1645            n           1259    27352    cardapio    TABLE �   CREATE TABLE cardapio (
    idcardapio integer NOT NULL,
    datacardapio date NOT NULL,
    qtderefeicoes integer NOT NULL,
    idrefeicao integer NOT NULL
);
    DROP TABLE public.cardapio;
       public         postgres    false    6            o           1259    27355    cardapioficha    TABLE e   CREATE TABLE cardapioficha (
    idcardapio integer NOT NULL,
    idfichatecnica integer NOT NULL
);
 !   DROP TABLE public.cardapioficha;
       public         postgres    false    6            �           1259    36244    cardapioordem    TABLE �   CREATE TABLE cardapioordem (
    idcardapioordem integer NOT NULL,
    idcardapio integer NOT NULL,
    idordemproducao integer NOT NULL
);
 !   DROP TABLE public.cardapioordem;
       public         postgres    false    6            �           1259    36262    cardapiopedido    TABLE �   CREATE TABLE cardapiopedido (
    idcardapiopedido integer NOT NULL,
    idcardapio integer NOT NULL,
    idpedido integer NOT NULL
);
 "   DROP TABLE public.cardapiopedido;
       public         postgres    false    6            �           1259    36221    cardapiosituacao    TABLE �   CREATE TABLE cardapiosituacao (
    idcardapiosituacao integer NOT NULL,
    idcardapio integer NOT NULL,
    idsituacaocardapio integer NOT NULL,
    datasituacao timestamp without time zone NOT NULL
);
 $   DROP TABLE public.cardapiosituacao;
       public         postgres    false    6            p           1259    27358    cargo    TABLE c   CREATE TABLE cargo (
    idcargo integer NOT NULL,
    descricao character varying(50) NOT NULL
);
    DROP TABLE public.cargo;
       public         postgres    false    6            q           1259    27361    composicaocentesimal    TABLE   CREATE TABLE composicaocentesimal (
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
       public         postgres    false    6            r           1259    27364    dadosbancarios    TABLE �   CREATE TABLE dadosbancarios (
    iddadosbancarios integer NOT NULL,
    idbanco integer NOT NULL,
    agencia character varying(20) NOT NULL,
    contacorrente character varying(20) NOT NULL,
    contacorrentedigito character varying(1) NOT NULL
);
 "   DROP TABLE public.dadosbancarios;
       public         postgres    false    6            s           1259    27367    email    TABLE �   CREATE TABLE email (
    idemail integer NOT NULL,
    email character varying(100) NOT NULL,
    idfornecedor integer NOT NULL
);
    DROP TABLE public.email;
       public         postgres    false    6            t           1259    27370    fichatecnica    TABLE �  CREATE TABLE fichatecnica (
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
       public         postgres    false    6            u           1259    27373    fichatecnicaitens    TABLE �   CREATE TABLE fichatecnicaitens (
    idfichatecnica integer NOT NULL,
    idproduto integer NOT NULL,
    pesobruto numeric(6,3),
    pesoliquido numeric(6,3),
    fatorcorrecao integer
);
 %   DROP TABLE public.fichatecnicaitens;
       public         postgres    false    6            v           1259    27376    formapagamento    TABLE �   CREATE TABLE formapagamento (
    idformapagamento integer NOT NULL,
    nome character varying(100) NOT NULL,
    operacaobancaria boolean NOT NULL
);
 "   DROP TABLE public.formapagamento;
       public         postgres    false    6            w           1259    27379    formapagamentofornecedor    TABLE �   CREATE TABLE formapagamentofornecedor (
    idformapagamentofornecedor integer NOT NULL,
    idformapagamento integer NOT NULL,
    idfornecedor integer NOT NULL
);
 ,   DROP TABLE public.formapagamentofornecedor;
       public         postgres    false    6            x           1259    27382 
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
       public         postgres    false    2019    6            y           1259    27386    fornecedorproduto    TABLE   CREATE TABLE fornecedorproduto (
    idfornecedorproduto integer NOT NULL,
    idproduto integer NOT NULL,
    idfornecedor integer NOT NULL,
    codprodutofornecedor character varying(10),
    tempoentrega integer,
    idtipofornecedor integer NOT NULL,
    preco numeric(12,2)
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
       public       postgres    false    6    1658            �           1259    27896    historicopedido    TABLE �   CREATE TABLE historicopedido (
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
       public         postgres    false    6            {           1259    27392 
   logsistema    TABLE �   CREATE TABLE logsistema (
    horario timestamp with time zone NOT NULL,
    operacao character varying(10) NOT NULL,
    logvinculado integer,
    idlogsistema integer NOT NULL,
    idusuario integer NOT NULL
);
    DROP TABLE public.logsistema;
       public         postgres    false    6            |           1259    27395 	   mensagens    TABLE �   CREATE TABLE mensagens (
    idmensagem integer NOT NULL,
    mensagem character varying(300) NOT NULL,
    tipomensagem integer DEFAULT 0 NOT NULL
);
    DROP TABLE public.mensagens;
       public         postgres    false    2023    6            }           1259    27399    motivo    TABLE ~   CREATE TABLE motivo (
    idmotivo integer NOT NULL,
    nome character varying(100) NOT NULL,
    baixar boolean NOT NULL
);
    DROP TABLE public.motivo;
       public         postgres    false    6            ~           1259    27402 	   movimento    TABLE   CREATE TABLE movimento (
    idmovimento integer NOT NULL,
    idproduto integer NOT NULL,
    quantidade numeric(9,3) NOT NULL,
    idunidademedida integer NOT NULL,
    idoperacao integer NOT NULL,
    motivooperacao character varying(100),
    datamovimento date NOT NULL
);
    DROP TABLE public.movimento;
       public         postgres    false    6                       1259    27405    operacao    TABLE �   CREATE TABLE operacao (
    idoperacao integer NOT NULL,
    descricao character varying(50) NOT NULL,
    vlfator integer NOT NULL
);
    DROP TABLE public.operacao;
       public         postgres    false    6            �           1259    27408    ordemproducao    TABLE $  CREATE TABLE ordemproducao (
    idordemproducao integer NOT NULL,
    dataordem date NOT NULL,
    idrefeicao integer NOT NULL,
    idorigemordem integer NOT NULL,
    idsituacaoordem integer NOT NULL,
    setor character varying(100) NOT NULL,
    motivo character varying(250) NOT NULL
);
 !   DROP TABLE public.ordemproducao;
       public         postgres    false    6            �           1259    27411    ordemproduto    TABLE �   CREATE TABLE ordemproduto (
    idordemproducao integer NOT NULL,
    idproduto integer NOT NULL,
    quantidade numeric(9,3) NOT NULL,
    idunidademedida integer NOT NULL,
    idordemproduto integer NOT NULL
);
     DROP TABLE public.ordemproduto;
       public         postgres    false    6            �           1259    27414    origemordem    TABLE o   CREATE TABLE origemordem (
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
       public         postgres    false    6            �           1259    27417    perfil    TABLE �   CREATE TABLE perfil (
    idperfil integer NOT NULL,
    nome character varying(100) NOT NULL,
    administrador boolean NOT NULL
);
    DROP TABLE public.perfil;
       public         postgres    false    6            �           1259    27420 
   perfiltela    TABLE �   CREATE TABLE perfiltela (
    idperfiltela integer NOT NULL,
    idperfil integer NOT NULL,
    idtela integer NOT NULL,
    idbotao integer
);
    DROP TABLE public.perfiltela;
       public         postgres    false    6            �           1259    27423    produto    TABLE �  CREATE TABLE produto (
    idproduto integer NOT NULL,
    codigo character varying(10) NOT NULL,
    nome character varying(100) NOT NULL,
    valor numeric(12,2),
    estoqueminimo numeric(6,3) DEFAULT 0 NOT NULL,
    qtdeembalagem numeric(6,3),
    temperaturaentrega numeric(6,2) NOT NULL,
    alimentar boolean NOT NULL,
    idcomposicaocentesimal integer,
    unidadeembalagem integer,
    unidadeestoque integer NOT NULL
);
    DROP TABLE public.produto;
       public         postgres    false    2034    6            r           1247    27428 	   proxyinfo    TYPE �   CREATE TYPE proxyinfo AS (
	serverversionstr text,
	serverversionnum integer,
	proxyapiver integer,
	serverprocessid integer
);
    DROP TYPE public.proxyinfo;
       public       postgres    false    6    1670            �           1259    27429    refeicao    TABLE i   CREATE TABLE refeicao (
    idrefeicao integer NOT NULL,
    descricao character varying(50) NOT NULL
);
    DROP TABLE public.refeicao;
       public         postgres    false    6            �           1259    27432    saldoano    TABLE E  CREATE TABLE saldoano (
    idsaldoano integer NOT NULL,
    ano integer NOT NULL,
    saldoentrada numeric(12,3) DEFAULT 0 NOT NULL,
    saldosaida numeric(12,3) DEFAULT 0 NOT NULL,
    saldocomprometido numeric(12,3) DEFAULT 0 NOT NULL,
    saldopendente numeric(12,3) DEFAULT 0 NOT NULL,
    idproduto integer NOT NULL
);
    DROP TABLE public.saldoano;
       public         postgres    false    2036    2037    2038    2039    6            �           1259    27439    saldodia    TABLE l  CREATE TABLE saldodia (
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
       public         postgres    false    2041    2042    2043    2044    6            �           1259    27446    saldomes    TABLE f  CREATE TABLE saldomes (
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
       public         postgres    false    2046    2047    2048    2049    6            �           1259    36213    situacaocardapio    TABLE z   CREATE TABLE situacaocardapio (
    idsituacaocardapio integer NOT NULL,
    descricao character varying(100) NOT NULL
);
 $   DROP TABLE public.situacaocardapio;
       public         postgres    false    6            �           1259    36188    situacaoitempedido    TABLE ~   CREATE TABLE situacaoitempedido (
    idsituacaoitempedido integer NOT NULL,
    descricao character varying(100) NOT NULL
);
 &   DROP TABLE public.situacaoitempedido;
       public         postgres    false    6            �           1259    27453    situacaoordem    TABLE s   CREATE TABLE situacaoordem (
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
       public       postgres    false    6    1676            �           1259    27459    tela    TABLE �   CREATE TABLE tela (
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
       public       postgres    false    6    1685            +            1255    27486    Gravar_Log()    FUNCTION pR CREATE FUNCTION "Gravar_Log"() RETURNS trigger
    AS $$/*******************************************************************************************************
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
 ----------------------------------     INFORMA��ES TABELA CARDAPIO ----------------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idcardapio = '|| NEW.idcardapio || '|';      
      TextoDados := TextoDados || 'datacardapio = '|| NEW.datacardapio || '|';      
      TextoDados := TextoDados || 'qtderefeicoes = '|| NEW.qtderefeicoes || '|';      
      TextoDados := TextoDados || 'idrefeicao = '|| NEW.idrefeicao || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idcardapio = '|| OLD.idcardapio || '|';      
      TextoDados := TextoDados || 'datacardapio = '|| OLD.datacardapio || '|';      
      TextoDados := TextoDados || 'qtderefeicoes = '|| OLD.qtderefeicoes || '|';      
      TextoDados := TextoDados || 'idrefeicao = '|| OLD.idrefeicao || '|';         
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
 ----------------------------------     INFORMA��ES TABELA CARDAPIOFICHA -----------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idcardapio = '|| NEW.idcardapio || '|';      
      TextoDados := TextoDados || 'idfichatecnica = '|| NEW.idfichatecnica || '|';        
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idcardapio = '|| OLD.idcardapio || '|';      
      TextoDados := TextoDados || 'idfichatecnica = '|| OLD.idfichatecnica || '|';          
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
 ----------------------------------     INFORMA��ES TABELA CARDAPIOORDEM -----------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idcardapioordem = '|| NEW.idcardapioordem || '|';      
      TextoDados := TextoDados || 'idcardapio = '|| NEW.idcardapio || '|';      
      TextoDados := TextoDados || 'idordemproducao = '|| NEW.idordemproducao || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idcardapioordem = '|| OLD.idcardapioordem || '|';      
      TextoDados := TextoDados || 'idcardapio = '|| OLD.idcardapio || '|';      
      TextoDados := TextoDados || 'idordemproducao = '|| OLD.idordemproducao || '|';         
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
 ----------------------------------     INFORMA��ES TABELA CARDAPIOPEDIDO ----------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idcardapiopedido = '|| NEW.idcardapiopedido || '|';      
      TextoDados := TextoDados || 'idcardapio = '|| NEW.idcardapio || '|';      
      TextoDados := TextoDados || 'idpedido = '|| NEW.idpedido || '|';       
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idcardapiopedido = '|| OLD.idcardapiopedido || '|';      
      TextoDados := TextoDados || 'idcardapio = '|| OLD.idcardapio || '|';      
      TextoDados := TextoDados || 'idpedido = '|| OLD.idpedido || '|';          
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
 ----------------------------------     INFORMA��ES TABELA CARDAPIOSITUA��O --------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idcardapiosituacao = '|| NEW.idcardapiosituacao || '|';      
      TextoDados := TextoDados || 'idcardapio = '|| NEW.idcardapio || '|';      
      TextoDados := TextoDados || 'idsituacaocardapio = '|| NEW.idsituacaocardapio || '|';      
      TextoDados := TextoDados || 'datasituacao = '|| NEW.datasituacao || '|';       
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idcardapiosituacao = '|| OLD.idcardapiosituacao || '|';      
      TextoDados := TextoDados || 'idcardapio = '|| OLD.idcardapio || '|';      
      TextoDados := TextoDados || 'idsituacaocardapio = '|| OLD.idsituacaocardapio || '|';      
      TextoDados := TextoDados || 'datasituacao = '|| OLD.datasituacao || '|';         
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
 ----------------------------------     INFORMA��ES TABELA COMPOSI��OCENTESIMAL ----------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idcomposicaocentesimal = '|| NEW.idcomposicaocentesimal || '|';      
      TextoDados := TextoDados || 'energia = '|| NEW.energia || '|';      
      TextoDados := TextoDados || 'carboidrato = '|| NEW.carboidrato || '|';      
      TextoDados := TextoDados || 'proteina = '|| NEW.proteina || '|';      
      TextoDados := TextoDados || 'lipideo = '|| NEW.lipideo || '|';     
      TextoDados := TextoDados || 'calcio = '|| NEW.calcio || '|';      
      TextoDados := TextoDados || 'ferro = '|| NEW.ferro || '|';     
      TextoDados := TextoDados || 'vitaminac = '|| NEW.vitaminac || '|';            
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idcomposicaocentesimal = '|| OLD.idcomposicaocentesimal || '|';      
      TextoDados := TextoDados || 'energia = '|| OLD.energia || '|';      
      TextoDados := TextoDados || 'carboidrato = '|| OLD.carboidrato || '|';      
      TextoDados := TextoDados || 'proteina = '|| OLD.proteina || '|';      
      TextoDados := TextoDados || 'lipideo = '|| OLD.lipideo || '|';     
      TextoDados := TextoDados || 'calcio = '|| OLD.calcio || '|';      
      TextoDados := TextoDados || 'ferro = '|| OLD.ferro || '|';     
      TextoDados := TextoDados || 'vitaminac = '|| OLD.vitaminac || '|';         
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
 ----------------------------------     INFORMA��ES TABELA DADOSBANCARIOS ----------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'iddadosbancarios = '|| NEW.iddadosbancarios || '|';      
      TextoDados := TextoDados || 'idbanco = '|| NEW.idbanco || '|';      
      TextoDados := TextoDados || 'agencia = '|| NEW.agencia || '|';      
      TextoDados := TextoDados || 'contacorrente = '|| NEW.contacorrente || '|';      
      TextoDados := TextoDados || 'contacorrentedigito = '|| NEW.contacorrentedigito || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'iddadosbancarios = '|| OLD.iddadosbancarios || '|';      
      TextoDados := TextoDados || 'idbanco = '|| OLD.idbanco || '|';      
      TextoDados := TextoDados || 'agencia = '|| OLD.agencia || '|';      
      TextoDados := TextoDados || 'contacorrente = '||OLD.contacorrente || '|';      
      TextoDados := TextoDados || 'contacorrentedigito = '|| OLD.contacorrentedigito || '|';      
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
 ----------------------------------     INFORMA��ES TABELA EMAIL -------------------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idemail = '|| NEW.idemail || '|';      
      TextoDados := TextoDados || 'email = '|| NEW.email || '|';      
      TextoDados := TextoDados || 'idfornecedor = '|| NEW.idfornecedor || '|';        
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idemail = '|| OLD.idemail || '|';      
      TextoDados := TextoDados || 'email = '|| OLD.email || '|';      
      TextoDados := TextoDados || 'idfornecedor = '|| OLD.idfornecedor || '|';          
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
 ----------------------------------     INFORMA��ES TABELA FICHATECNICA ------------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idfichatecnica = '|| NEW.idfichatecnica || '|';      
      TextoDados := TextoDados || 'nomepreparacao = '|| NEW.nomepreparacao || '|';      
      TextoDados := TextoDados || 'modopreparo = '|| NEW.modopreparo || '|';      
      TextoDados := TextoDados || 'rendimento = '|| NEW.rendimento || '|';      
      TextoDados := TextoDados || 'energia = '|| NEW.energia || '|';      
      TextoDados := TextoDados || 'carboidrato = '|| NEW.carboidrato || '|';      
      TextoDados := TextoDados || 'proteina = '|| NEW.proteina || '|';      
      TextoDados := TextoDados || 'lipideo = '|| NEW.lipideo || '|';      
      TextoDados := TextoDados || 'calcio = '|| NEW.calcio || '|';      
      TextoDados := TextoDados || 'ferro = '|| NEW.ferro || '|';     
      TextoDados := TextoDados || 'vitaminac = '|| NEW.vitaminac || '|';      
      TextoDados := TextoDados || 'pesocru = '|| NEW.pesocru || '|';      
      TextoDados := TextoDados || 'pesoliquido = '|| NEW.pesoliquido || '|';      
      TextoDados := TextoDados || 'precototal = '|| NEW.precototal || '|';       
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idfichatecnica = '|| OLD.idfichatecnica || '|';      
      TextoDados := TextoDados || 'nomepreparacao = '|| OLD.nomepreparacao || '|';      
      TextoDados := TextoDados || 'modopreparo = '|| OLD.modopreparo || '|';      
      TextoDados := TextoDados || 'rendimento = '|| OLD.rendimento || '|';      
      TextoDados := TextoDados || 'energia = '|| OLD.energia || '|';      
      TextoDados := TextoDados || 'carboidrato = '|| OLD.carboidrato || '|';      
      TextoDados := TextoDados || 'proteina = '|| OLD.proteina || '|';      
      TextoDados := TextoDados || 'lipideo = '|| OLD.lipideo || '|';      
      TextoDados := TextoDados || 'calcio = '|| OLD.calcio || '|';      
      TextoDados := TextoDados || 'ferro = '|| OLD.ferro || '|';     
      TextoDados := TextoDados || 'vitaminac = '|| OLD.vitaminac || '|';      
      TextoDados := TextoDados || 'pesocru = '|| OLD.pesocru || '|';      
      TextoDados := TextoDados || 'pesoliquido = '|| OLD.pesoliquido || '|';      
      TextoDados := TextoDados || 'precototal = '|| OLD.precototal || '|';        
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
 ----------------------------------     INFORMA��ES TABELA FICHATECNICAITENS -------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idfichatecnica = '|| NEW.idfichatecnica || '|';      
      TextoDados := TextoDados || 'idproduto = '|| NEW.idproduto || '|';      
      TextoDados := TextoDados || 'pesobruto = '|| NEW.pesobruto || '|';      
      TextoDados := TextoDados || 'pesoliquido = '|| NEW.pesoliquido || '|';      
      TextoDados := TextoDados || 'fatorcorrecao = '|| NEW.fatorcorrecao || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idfichatecnica = '|| OLD.idfichatecnica || '|';      
      TextoDados := TextoDados || 'idproduto = '|| OLD.idproduto || '|';      
      TextoDados := TextoDados || 'pesobruto = '|| OLD.pesobruto || '|';      
      TextoDados := TextoDados || 'pesoliquido = '|| OLD.pesoliquido || '|';      
      TextoDados := TextoDados || 'fatorcorrecao = '|| OLD.fatorcorrecao || '|';      
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
 ----------------------------------     INFORMA��ES TABELA FORMAPAGAMENTO ----------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idformapagamento = '|| NEW.idformapagamento || '|';      
      TextoDados := TextoDados || 'nome = '|| NEW.nome || '|';      
      TextoDados := TextoDados || 'operacaobancaria = '|| NEW.operacaobancaria || '|';       
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idformapagamento = '|| OLD.idformapagamento || '|';      
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
 ----------------------------------     INFORMA��ES TABELA FORMAPAGAMENTOFORNECEDOR ------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idformapagamentofornecedor = '|| NEW.idformapagamentofornecedor || '|';      
      TextoDados := TextoDados || 'idformapagamento = '|| NEW.idformapagamento || '|';      
      TextoDados := TextoDados || 'idfornecedor = '|| NEW.idfornecedor || '|';        
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idformapagamentofornecedor = '|| OLD.idformapagamentofornecedor || '|';      
      TextoDados := TextoDados || 'idformapagamento = '|| OLD.idformapagamento || '|';      
      TextoDados := TextoDados || 'idfornecedor = '|| OLD.idfornecedor || '|';          
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
 ----------------------------------     INFORMA��ES TABELA FORNECEDOR --------------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idfornecedor = '|| NEW.idfornecedor || '|';      
      TextoDados := TextoDados || 'codigo = '|| NEW.codigo || '|';      
      TextoDados := TextoDados || 'razaosocial = '|| NEW.razaosocial || '|';      
      TextoDados := TextoDados || 'cnpj = '|| NEW.cnpj || '|';      
      TextoDados := TextoDados || 'inscricaoestadual = '|| NEW.inscricaoestadual || '|';      
      TextoDados := TextoDados || 'ccm = '|| NEW.ccm || '|';      
      TextoDados := TextoDados || 'cgc = '|| NEW.cgc || '|';      
      TextoDados := TextoDados || 'rua = '|| NEW.rua || '|';      
      TextoDados := TextoDados || 'numero = '|| NEW.numero || '|';      
      TextoDados := TextoDados || 'bairro = '|| NEW.bairro || '|';     
      TextoDados := TextoDados || 'cidade = '|| NEW.cidade || '|';      
      TextoDados := TextoDados || 'cep = '|| NEW.cep || '|';      
      TextoDados := TextoDados || 'site = '|| NEW.site || '|';      
      TextoDados := TextoDados || 'tempoentrega = '|| NEW.tempoentrega || '|';      
      TextoDados := TextoDados || 'iddadosbancarios = '|| NEW.iddadosbancarios || '|';     
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idfornecedor = '|| OLD.idfornecedor || '|';      
      TextoDados := TextoDados || 'codigo = '|| OLD.codigo || '|';      
      TextoDados := TextoDados || 'razaosocial = '|| OLD.razaosocial || '|';      
      TextoDados := TextoDados || 'cnpj = '|| OLD.cnpj || '|';      
      TextoDados := TextoDados || 'inscricaoestadual = '|| OLD.inscricaoestadual || '|';      
      TextoDados := TextoDados || 'ccm = '|| OLD.ccm || '|';      
      TextoDados := TextoDados || 'cgc = '|| OLD.cgc || '|';      
      TextoDados := TextoDados || 'rua = '|| OLD.rua || '|';      
      TextoDados := TextoDados || 'numero = '|| OLD.numero || '|';      
      TextoDados := TextoDados || 'bairro = '|| OLD.bairro || '|';     
      TextoDados := TextoDados || 'cidade = '|| OLD.cidade || '|';      
      TextoDados := TextoDados || 'cep = '|| OLD.cep || '|';      
      TextoDados := TextoDados || 'site = '|| OLD.site || '|';      
      TextoDados := TextoDados || 'tempoentrega = '|| OLD.tempoentrega || '|';      
      TextoDados := TextoDados || 'iddadosbancarios = '|| OLD.iddadosbancarios || '|';          
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
 ----------------------------------     INFORMA��ES TABELA FORNECEDORPRODUTO -------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idfornecedorproduto = '|| NEW.idfornecedorproduto || '|';      
      TextoDados := TextoDados || 'idproduto = '|| NEW.idproduto || '|';      
      TextoDados := TextoDados || 'idfornecedor = '|| NEW.idfornecedor || '|';      
      TextoDados := TextoDados || 'codprodutofornecedor = '|| NEW.codprodutofornecedor || '|';      
      TextoDados := TextoDados || 'tempoentrega = '|| NEW.tempoentrega || '|';      
      TextoDados := TextoDados || 'idtipofornecedor = '|| NEW.idtipofornecedor || '|';      
      TextoDados := TextoDados || 'preco = '|| NEW.preco || '|';         
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idfornecedorproduto = '|| OLD.idfornecedorproduto || '|';      
      TextoDados := TextoDados || 'idproduto = '|| OLD.idproduto || '|';      
      TextoDados := TextoDados || 'idfornecedor = '|| OLD.idfornecedor || '|';      
      TextoDados := TextoDados || 'codprodutofornecedor = '|| OLD.codprodutofornecedor || '|';      
      TextoDados := TextoDados || 'tempoentrega = '|| OLD.tempoentrega || '|';      
      TextoDados := TextoDados || 'idtipofornecedor = '|| OLD.idtipofornecedor || '|';      
      TextoDados := TextoDados || 'preco = '|| OLD.preco || '|';   
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
 ----------------------------------     INFORMA��ES TABELA HISTORICOPEDIDO ---------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idhistoricopedido = '|| NEW.idhistoricopedido || '|';      
      TextoDados := TextoDados || 'idpedido = '|| NEW.idpedido || '|';      
      TextoDados := TextoDados || 'idsituacaopedido = '|| NEW.idsituacaopedido || '|';      
      TextoDados := TextoDados || 'datahistoricopedido = '|| NEW.datahistoricopedido || '|';         
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idhistoricopedido = '|| OLD.idhistoricopedido || '|';      
      TextoDados := TextoDados || 'idpedido = '|| OLD.idpedido || '|';      
      TextoDados := TextoDados || 'idsituacaopedido = '|| OLD.idsituacaopedido || '|';      
      TextoDados := TextoDados || 'datahistoricopedido = '|| OLD.datahistoricopedido || '|';          
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
 ----------------------------------     INFORMA��ES TABELA ITEMAVALIA��O -----------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'iditemavaliacao = '|| NEW.iditemavaliacao || '|';      
      TextoDados := TextoDados || 'iditempedido = '|| NEW.iditempedido || '|';      
      TextoDados := TextoDados || 'idmotivo = '|| NEW.idmotivo || '|';      
      TextoDados := TextoDados || 'idsituacaoitempedido = '|| NEW.idsituacaoitempedido || '|';      
      TextoDados := TextoDados || 'adequado = '|| NEW.adequado || '|';      
      TextoDados := TextoDados || 'dataavaliacao = '|| NEW.dataavaliacao || '|';     
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'iditemavaliacao = '|| OLD.iditemavaliacao || '|';      
      TextoDados := TextoDados || 'iditempedido = '|| OLD.iditempedido || '|';      
      TextoDados := TextoDados || 'idmotivo = '|| OLD.idmotivo || '|';      
      TextoDados := TextoDados || 'idsituacaoitempedido = '|| OLD.idsituacaoitempedido || '|';      
      TextoDados := TextoDados || 'adequado = '|| OLD.adequado || '|';      
      TextoDados := TextoDados || 'dataavaliacao = '|| OLD.dataavaliacao || '|';     
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
 ----------------------------------     INFORMA��ES TABELA ITEMPEDIDO --------------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'iditempedido = '|| NEW.iditempedido || '|';      
      TextoDados := TextoDados || 'idpedido = '|| NEW.idpedido || '|';      
      TextoDados := TextoDados || 'idproduto = '|| NEW.idproduto || '|';      
      TextoDados := TextoDados || 'quantidade = '|| NEW.quantidade || '|';      
      TextoDados := TextoDados || 'idunidademedida = '|| NEW.idunidademedida || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'iditempedido = '|| OLD.iditempedido || '|';      
      TextoDados := TextoDados || 'idpedido = '|| OLD.idpedido || '|';      
      TextoDados := TextoDados || 'idproduto = '|| OLD.idproduto || '|';      
      TextoDados := TextoDados || 'quantidade = '|| OLD.quantidade || '|';      
      TextoDados := TextoDados || 'idunidademedida = '|| OLD.idunidademedida || '|';        
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
  ----------------------------------    INFORMA��ES TABELA MOVIMENTO ---------------------------------------
     IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idmovimento = '|| NEW.idmovimento || '|';      
      TextoDados := TextoDados || 'idproduto = '|| NEW.idproduto || '|';      
      TextoDados := TextoDados || 'quantidade = '|| NEW.quantidade || '|';      
      TextoDados := TextoDados || 'idunidademedida = '|| NEW.idunidademedida || '|';      
      TextoDados := TextoDados || 'idoperacao = '|| NEW.idoperacao || '|';      
      TextoDados := TextoDados || 'quantidade = '|| NEW.quantidade || '|';      
      TextoDados := TextoDados || 'motivooperacao = '|| NEW.motivooperacao || '|';      
      TextoDados := TextoDados || 'datamovimento = '|| NEW.datamovimento || '|';         
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idmovimento = '|| OLD.idmovimento || '|';      
      TextoDados := TextoDados || 'idproduto = '|| OLD.idproduto || '|';      
      TextoDados := TextoDados || 'quantidade = '|| OLD.quantidade || '|';      
      TextoDados := TextoDados || 'idunidademedida = '|| OLD.idunidademedida || '|';      
      TextoDados := TextoDados || 'idoperacao = '|| OLD.idoperacao || '|';      
      TextoDados := TextoDados || 'quantidade = '|| OLD.quantidade || '|';      
      TextoDados := TextoDados || 'motivooperacao = '|| OLD.motivooperacao || '|';      
      TextoDados := TextoDados || 'datamovimento = '|| OLD.datamovimento || '|';         
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
 ----------------------------------     INFORMA��ES TABELA OPERA��O ----------------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idoperacao = '|| NEW.idoperacao || '|';      
      TextoDados := TextoDados || 'descricao = '|| NEW.descricao || '|';      
      TextoDados := TextoDados || 'vlfator = '|| NEW.vlfator || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idoperacao = '|| OLD.idoperacao || '|';      
      TextoDados := TextoDados || 'descricao = '|| OLD.descricao || '|';      
      TextoDados := TextoDados || 'vlfator = '|| OLD.vlfator || '|';      
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
 ----------------------------------     INFORMA��ES TABELA ORDEMPRODU��O -----------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idordemproducao = '|| NEW.idordemproducao || '|';      
      TextoDados := TextoDados || 'dataordem = '|| NEW.dataordem || '|';      
      TextoDados := TextoDados || 'idrefeicao = '|| NEW.idrefeicao || '|';      
      TextoDados := TextoDados || 'idorigemordem = '|| NEW.idorigemordem || '|';      
      TextoDados := TextoDados || 'idsituacaoordem = '|| NEW.idsituacaoordem || '|';      
      TextoDados := TextoDados || 'setor = '|| NEW.setor || '|';      
      TextoDados := TextoDados || 'motivo = '|| NEW.motivo || '|';    
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idordemproducao = '|| OLD.idordemproducao || '|';      
      TextoDados := TextoDados || 'dataordem = '|| OLD.dataordem || '|';      
      TextoDados := TextoDados || 'idrefeicao = '|| OLD.idrefeicao || '|';      
      TextoDados := TextoDados || 'idorigemordem = '|| OLD.idorigemordem || '|';      
      TextoDados := TextoDados || 'idsituacaoordem = '|| OLD.idsituacaoordem || '|';      
      TextoDados := TextoDados || 'setor = '|| OLD.setor || '|';      
      TextoDados := TextoDados || 'motivo = '|| OLD.motivo || '|';   
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
 ----------------------------------     INFORMA��ES TABELA ORDEMPRODUTO ------------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idordemproducao = '|| NEW.idordemproducao || '|';      
      TextoDados := TextoDados || 'idproduto = '|| NEW.idproduto || '|';      
      TextoDados := TextoDados || 'quantidade = '|| NEW.quantidade || '|';      
      TextoDados := TextoDados || 'idunidademedida = '|| NEW.idunidademedida	 || '|';      
      TextoDados := TextoDados || 'idordemproduto = '|| NEW.idordemproduto || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idordemproducao = '|| OLD.idordemproducao || '|';      
      TextoDados := TextoDados || 'idproduto = '|| OLD.idproduto || '|';      
      TextoDados := TextoDados || 'quantidade = '|| OLD.quantidade || '|';      
      TextoDados := TextoDados || 'idunidademedida = '|| OLD.idunidademedida	 || '|';      
      TextoDados := TextoDados || 'idordemproduto = '|| OLD.idordemproduto || '|';    
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
 ----------------------------------     INFORMA��ES TABELA ORIGEMORDEM -------------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idorigemordem = '|| NEW.idorigemordem || '|';      
      TextoDados := TextoDados || 'descricao = '|| NEW.descricao || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idorigemordem = '|| OLD.idorigemordem || '|';      
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
 ----------------------------------     INFORMA��ES TABELA PEDIDO ------------------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idpedido = '|| NEW.idpedido || '|';      
      TextoDados := TextoDados || 'idfornecedor = '|| NEW.idfornecedor || '|';      
      TextoDados := TextoDados || 'dataentrega = '|| NEW.dataentrega || '|';        
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idpedido = '|| OLD.idpedido || '|';      
      TextoDados := TextoDados || 'idfornecedor = '|| OLD.idfornecedor || '|';      
      TextoDados := TextoDados || 'dataentrega = '|| OLD.dataentrega || '|';        
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
 ----------------------------------     INFORMA��ES TABELA PRODUTO -----------------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idproduto = '|| NEW.idproduto || '|';      
      TextoDados := TextoDados || 'codigo = '|| NEW.codigo || '|';      
      TextoDados := TextoDados || 'nome = '|| NEW.nome || '|';      
      TextoDados := TextoDados || 'valor = '|| NEW.valor || '|';      
      TextoDados := TextoDados || 'estoqueminimo = '|| NEW.estoqueminimo || '|';      
      TextoDados := TextoDados || 'qtdeembalagem = '|| NEW.qtdeembalagem || '|';      
      TextoDados := TextoDados || 'temperaturaentrega = '|| NEW.temperaturaentrega || '|';      
      TextoDados := TextoDados || 'idcomposicaocentesimal = '|| NEW.idcomposicaocentesimal || '|';      
      TextoDados := TextoDados || 'unidadeembalagem = '|| NEW.unidadeembalagem || '|';      
      TextoDados := TextoDados || 'unidadeestoque = '|| NEW.unidadeestoque || '|';   
      TextoDados := TextoDados || 'alimentar = '|| NEW.alimentar || '|';               
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idproduto = '|| OLD.idproduto || '|';      
      TextoDados := TextoDados || 'codigo = '|| OLD.codigo || '|';      
      TextoDados := TextoDados || 'nome = '|| OLD.nome || '|';      
      TextoDados := TextoDados || 'valor = '|| OLD.valor || '|';      
      TextoDados := TextoDados || 'estoqueminimo = '|| OLD.estoqueminimo || '|';      
      TextoDados := TextoDados || 'qtdeembalagem = '|| OLD.qtdeembalagem || '|';      
      TextoDados := TextoDados || 'temperaturaentrega = '|| OLD.temperaturaentrega || '|';      
      TextoDados := TextoDados || 'idcomposicaocentesimal = '|| OLD.idcomposicaocentesimal || '|';      
      TextoDados := TextoDados || 'unidadeembalagem = '|| OLD.unidadeembalagem || '|';      
      TextoDados := TextoDados || 'unidadeestoque = '|| OLD.unidadeestoque || '|';   
      TextoDados := TextoDados || 'alimentar = '|| OLD.alimentar || '|';        
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
 ----------------------------------     INFORMA��ES TABELA REFEI��O ----------------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idrefeicao = '|| NEW.idrefeicao || '|';      
      TextoDados := TextoDados || 'descricao = '|| NEW.descricao || '|';       
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idrefeicao = '|| OLD.idrefeicao || '|';      
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
 ----------------------------------     INFORMA��ES TABELA SALDOANO ----------------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idsaldoano = '|| NEW.idsaldoano || '|';      
      TextoDados := TextoDados || 'ano = '|| NEW.ano || '|';      
      TextoDados := TextoDados || 'saldoentrada = '|| NEW.saldoentrada || '|';      
      TextoDados := TextoDados || 'saldosaida = '|| NEW.saldosaida || '|';      
      TextoDados := TextoDados || 'saldocomprometido = '|| NEW.saldocomprometido || '|';      
      TextoDados := TextoDados || 'saldopendente = '|| NEW.saldopendente || '|';      
      TextoDados := TextoDados || 'idproduto = '|| NEW.idproduto || '|';            
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idsaldoano = '|| OLD.idsaldoano || '|';      
      TextoDados := TextoDados || 'ano = '|| OLD.ano || '|';      
      TextoDados := TextoDados || 'saldoentrada = '|| OLD.saldoentrada || '|';      
      TextoDados := TextoDados || 'saldosaida = '|| OLD.saldosaida || '|';      
      TextoDados := TextoDados || 'saldocomprometido = '|| OLD.saldocomprometido || '|';      
      TextoDados := TextoDados || 'saldopendente = '|| OLD.saldopendente || '|';      
      TextoDados := TextoDados || 'idproduto = '|| OLD.idproduto || '|';         
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
 ----------------------------------     INFORMA��ES TABELA SALDODIA ----------------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idsaldodia = '|| NEW.idsaldodia || '|';      
      TextoDados := TextoDados || 'datasaldodia = '|| NEW.datasaldodia || '|';      
      TextoDados := TextoDados || 'saldoentrada = '|| NEW.saldoentrada || '|';      
      TextoDados := TextoDados || 'saldosaida = '|| NEW.saldosaida || '|';      
      TextoDados := TextoDados || 'saldocomprometido = '|| NEW.saldocomprometido || '|';      
      TextoDados := TextoDados || 'saldopendente = '|| NEW.saldopendente || '|';        
      TextoDados := TextoDados || 'idsaldomes = '|| NEW.idsaldomes || '|';      
      TextoDados := TextoDados || 'idproduto = '|| NEW.idproduto || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idsaldodia = '|| OLD.idsaldodia || '|';      
      TextoDados := TextoDados || 'datasaldodia = '|| OLD.datasaldodia || '|';      
      TextoDados := TextoDados || 'saldoentrada = '|| OLD.saldoentrada || '|';      
      TextoDados := TextoDados || 'saldosaida = '|| OLD.saldosaida || '|';      
      TextoDados := TextoDados || 'saldocomprometido = '|| OLD.saldocomprometido || '|';      
      TextoDados := TextoDados || 'saldopendente = '|| OLD.saldopendente || '|';        
      TextoDados := TextoDados || 'idsaldomes = '|| OLD.idsaldomes || '|';      
      TextoDados := TextoDados || 'idproduto = '|| OLD.idproduto || '|';      
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
 ----------------------------------     INFORMA��ES TABELA SALDOMES ----------------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idsaldomes = '|| NEW.idsaldomes || '|';      
      TextoDados := TextoDados || 'mes = '|| NEW.mes || '|';      
      TextoDados := TextoDados || 'saldoentrada = '|| NEW.saldoentrada || '|';      
      TextoDados := TextoDados || 'saldosaida = '|| NEW.saldosaida || '|';      
      TextoDados := TextoDados || 'saldocomprometido = '|| NEW.saldocomprometido || '|';      
      TextoDados := TextoDados || 'saldopendente = '|| NEW.saldopendente || '|';       
      TextoDados := TextoDados || 'idproduto = '|| NEW.idproduto || '|';      
      TextoDados := TextoDados || 'idsaldoano = '|| NEW.idsaldoano || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idsaldomes = '|| OLD.idsaldomes || '|';      
      TextoDados := TextoDados || 'mes = '|| OLD.mes || '|';      
      TextoDados := TextoDados || 'saldoentrada = '|| OLD.saldoentrada || '|';      
      TextoDados := TextoDados || 'saldosaida = '|| OLD.saldosaida || '|';      
      TextoDados := TextoDados || 'saldocomprometido = '|| OLD.saldocomprometido || '|';      
      TextoDados := TextoDados || 'saldopendente = '|| OLD.saldopendente || '|';       
      TextoDados := TextoDados || 'idproduto = '|| OLD.idproduto || '|';      
      TextoDados := TextoDados || 'idsaldoano = '|| OLD.idsaldoano || '|';   
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
 ----------------------------------     INFORMA��ES TABELA SITUACAOCARDAPIO --------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idsituacaocardapio = '|| NEW.idsituacaocardapio || '|';      
      TextoDados := TextoDados || 'descricao = '|| NEW.descricao || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idsituacaocardapio = '|| OLD.idsituacaocardapio || '|';      
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
 ----------------------------------     INFORMA��ES TABELA SITUACAOITEMPEDIDO-------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idsituacaoitempedido = '|| NEW.idsituacaoitempedido || '|';      
      TextoDados := TextoDados || 'descricao = '|| NEW.descricao || '|';         
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idsituacaoitempedido = '|| OLD.idsituacaoitempedido || '|';      
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
 ----------------------------------     INFORMA��ES TABELA SITUACAOORDEM -----------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idsituacaoordem = '|| NEW.idsituacaoordem || '|';      
      TextoDados := TextoDados || 'descricao = '|| NEW.descricao || '|';        
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idsituacaoordem = '|| OLD.idsituacaoordem || '|';      
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
 ----------------------------------     INFORMA��ES TABELA SITUACAOPEDIDO ----------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idsituacaopedido = '|| NEW.idsituacaopedido || '|';      
      TextoDados := TextoDados || 'descricao = '|| NEW.descricao || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idsituacaopedido = '|| OLD.idsituacaopedido || '|';      
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
 ----------------------------------     INFORMA��ES TABELA TELEFONE ----------------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idtelefone = '|| NEW.idtelefone || '|';      
      TextoDados := TextoDados || 'ddd = '|| NEW.ddd || '|';      
      TextoDados := TextoDados || 'telefone = '|| NEW.telefone || '|';      
      TextoDados := TextoDados || 'idfornecedor = '|| NEW.idfornecedor || '|';      
      TextoDados := TextoDados || 'idtipotelefone = '|| NEW.idtipotelefone || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idtelefone = '|| OLD.idtelefone || '|';      
      TextoDados := TextoDados || 'ddd = '|| OLD.ddd || '|';      
      TextoDados := TextoDados || 'telefone = '|| OLD.telefone || '|';      
      TextoDados := TextoDados || 'idfornecedor = '|| OLD.idfornecedor || '|';      
      TextoDados := TextoDados || 'idtipotelefone = '|| OLD.idtipotelefone || '|';    
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
 ----------------------------------     INFORMA��ES TABELA TIPOFORNECEDOR ----------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idtipofornecedor = '|| NEW.idtipofornecedor || '|';      
      TextoDados := TextoDados || 'descricao = '|| NEW.descricao || '|';       
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idtipofornecedor = '|| OLD.idtipofornecedor || '|';      
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
 ----------------------------------     INFORMA��ES TABELA TIPOTELEFONE ------------------------------------
    IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idtipotelefone = '|| NEW.idtipotelefone || '|';      
      TextoDados := TextoDados || 'descricao = '|| NEW.descricao || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;   
      TextoDados := TextoDados || 'idtipotelefone = '|| OLD.idtipotelefone || '|';      
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
 RETURN NULL;
 END;$$
    LANGUAGE plpgsql;
 %   DROP FUNCTION public."Gravar_Log"();
       public       postgres    false    470    6                        1255    27488 5   gravarsaldo(date, integer, numeric, integer, integer)    FUNCTION �B  CREATE FUNCTION gravarsaldo(datasaldo date, produto integer, valor numeric, tiposaldo integer, operacao integer, OUT gravousaldo boolean) RETURNS boolean
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
       public       postgres    false    6    470                        1255    27490    pldbg_abort_target(integer)    FUNCTION �   CREATE FUNCTION pldbg_abort_target(session integer) RETURNS SETOF boolean
    AS '$libdir/pldbgapi', 'pldbg_abort_target'
    LANGUAGE c STRICT;
 :   DROP FUNCTION public.pldbg_abort_target(session integer);
       public       postgres    false    6                        1255    27491    pldbg_attach_to_port(integer)    FUNCTION �   CREATE FUNCTION pldbg_attach_to_port(portnumber integer) RETURNS integer
    AS '$libdir/pldbgapi', 'pldbg_attach_to_port'
    LANGUAGE c STRICT;
 ?   DROP FUNCTION public.pldbg_attach_to_port(portnumber integer);
       public       postgres    false    6                        1255    27492    pldbg_continue(integer)    FUNCTION �   CREATE FUNCTION pldbg_continue(session integer) RETURNS breakpoint
    AS '$libdir/pldbgapi', 'pldbg_continue'
    LANGUAGE c STRICT;
 6   DROP FUNCTION public.pldbg_continue(session integer);
       public       postgres    false    6    320                        1255    27493    pldbg_create_listener()    FUNCTION �   CREATE FUNCTION pldbg_create_listener() RETURNS integer
    AS '$libdir/pldbgapi', 'pldbg_create_listener'
    LANGUAGE c STRICT;
 .   DROP FUNCTION public.pldbg_create_listener();
       public       postgres    false    6                        1255    27494 1   pldbg_deposit_value(integer, text, integer, text)    FUNCTION �   CREATE FUNCTION pldbg_deposit_value(session integer, varname text, linenumber integer, value text) RETURNS boolean
    AS '$libdir/pldbgapi', 'pldbg_deposit_value'
    LANGUAGE c STRICT;
 i   DROP FUNCTION public.pldbg_deposit_value(session integer, varname text, linenumber integer, value text);
       public       postgres    false    6                        1255    27495 ,   pldbg_drop_breakpoint(integer, oid, integer)    FUNCTION �   CREATE FUNCTION pldbg_drop_breakpoint(session integer, func oid, linenumber integer) RETURNS boolean
    AS '$libdir/pldbgapi', 'pldbg_drop_breakpoint'
    LANGUAGE c STRICT;
 [   DROP FUNCTION public.pldbg_drop_breakpoint(session integer, func oid, linenumber integer);
       public       postgres    false    6                        1255    27496    pldbg_get_breakpoints(integer)    FUNCTION �   CREATE FUNCTION pldbg_get_breakpoints(session integer) RETURNS SETOF breakpoint
    AS '$libdir/pldbgapi', 'pldbg_get_breakpoints'
    LANGUAGE c STRICT;
 =   DROP FUNCTION public.pldbg_get_breakpoints(session integer);
       public       postgres    false    6    320                        1255    27497    pldbg_get_proxy_info()    FUNCTION �   CREATE FUNCTION pldbg_get_proxy_info() RETURNS proxyinfo
    AS '$libdir/pldbgapi', 'pldbg_get_proxy_info'
    LANGUAGE c STRICT;
 -   DROP FUNCTION public.pldbg_get_proxy_info();
       public       postgres    false    370    6                        1255    27498    pldbg_get_source(integer, oid)    FUNCTION �   CREATE FUNCTION pldbg_get_source(session integer, func oid) RETURNS text
    AS '$libdir/pldbgapi', 'pldbg_get_source'
    LANGUAGE c STRICT;
 B   DROP FUNCTION public.pldbg_get_source(session integer, func oid);
       public       postgres    false    6                        1255    27499    pldbg_get_stack(integer)    FUNCTION �   CREATE FUNCTION pldbg_get_stack(session integer) RETURNS SETOF frame
    AS '$libdir/pldbgapi', 'pldbg_get_stack'
    LANGUAGE c STRICT;
 7   DROP FUNCTION public.pldbg_get_stack(session integer);
       public       postgres    false    346    6                        1255    27500 #   pldbg_get_target_info(text, "char")    FUNCTION �   CREATE FUNCTION pldbg_get_target_info(signature text, targettype "char") RETURNS targetinfo
    AS '$libdir/targetinfo', 'pldbg_get_target_info'
    LANGUAGE c STRICT;
 O   DROP FUNCTION public.pldbg_get_target_info(signature text, targettype "char");
       public       postgres    false    382    6                         1255    27501    pldbg_get_variables(integer)    FUNCTION �   CREATE FUNCTION pldbg_get_variables(session integer) RETURNS SETOF var
    AS '$libdir/pldbgapi', 'pldbg_get_variables'
    LANGUAGE c STRICT;
 ;   DROP FUNCTION public.pldbg_get_variables(session integer);
       public       postgres    false    6    400            !            1255    27502 $   pldbg_select_frame(integer, integer)    FUNCTION �   CREATE FUNCTION pldbg_select_frame(session integer, frame integer) RETURNS breakpoint
    AS '$libdir/pldbgapi', 'pldbg_select_frame'
    LANGUAGE c STRICT;
 I   DROP FUNCTION public.pldbg_select_frame(session integer, frame integer);
       public       postgres    false    320    6            "            1255    27503 +   pldbg_set_breakpoint(integer, oid, integer)    FUNCTION �   CREATE FUNCTION pldbg_set_breakpoint(session integer, func oid, linenumber integer) RETURNS boolean
    AS '$libdir/pldbgapi', 'pldbg_set_breakpoint'
    LANGUAGE c STRICT;
 Z   DROP FUNCTION public.pldbg_set_breakpoint(session integer, func oid, linenumber integer);
       public       postgres    false    6            #            1255    27504 ;   pldbg_set_global_breakpoint(integer, oid, integer, integer)    FUNCTION �   CREATE FUNCTION pldbg_set_global_breakpoint(session integer, func oid, linenumber integer, targetpid integer) RETURNS boolean
    AS '$libdir/pldbgapi', 'pldbg_set_global_breakpoint'
    LANGUAGE c;
 t   DROP FUNCTION public.pldbg_set_global_breakpoint(session integer, func oid, linenumber integer, targetpid integer);
       public       postgres    false    6            $            1255    27505    pldbg_step_into(integer)    FUNCTION �   CREATE FUNCTION pldbg_step_into(session integer) RETURNS breakpoint
    AS '$libdir/pldbgapi', 'pldbg_step_into'
    LANGUAGE c STRICT;
 7   DROP FUNCTION public.pldbg_step_into(session integer);
       public       postgres    false    320    6            %            1255    27506    pldbg_step_over(integer)    FUNCTION �   CREATE FUNCTION pldbg_step_over(session integer) RETURNS breakpoint
    AS '$libdir/pldbgapi', 'pldbg_step_over'
    LANGUAGE c STRICT;
 7   DROP FUNCTION public.pldbg_step_over(session integer);
       public       postgres    false    6    320            &            1255    27507 "   pldbg_wait_for_breakpoint(integer)    FUNCTION �   CREATE FUNCTION pldbg_wait_for_breakpoint(session integer) RETURNS breakpoint
    AS '$libdir/pldbgapi', 'pldbg_wait_for_breakpoint'
    LANGUAGE c STRICT;
 A   DROP FUNCTION public.pldbg_wait_for_breakpoint(session integer);
       public       postgres    false    320    6            '            1255    27508    pldbg_wait_for_target(integer)    FUNCTION �   CREATE FUNCTION pldbg_wait_for_target(session integer) RETURNS integer
    AS '$libdir/pldbgapi', 'pldbg_wait_for_target'
    LANGUAGE c STRICT;
 =   DROP FUNCTION public.pldbg_wait_for_target(session integer);
       public       postgres    false    6            (            1255    27509    plpgsql_oid_debug(oid)    FUNCTION �   CREATE FUNCTION plpgsql_oid_debug(functionoid oid) RETURNS integer
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
    IF (tiposaldo = 3) OR (tiposaldo = 6)THEN
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
        WHERE sd.datasaldodia > datasaldo 
        AND sd.idproduto = produto;  

        ValorComprometidoReal := VerificaNull(ValorAno, 0.0) + VerificaNull(ValorMes,0.0) + VerificaNull(ValorDia,0.0); 
        --soma-se o pendente iniciando do primeiro dia do mes;
        saldo := ValorComprometidoReal;        
    END IF;
    IF (tiposaldo = 6) THEN
        ValorComprometidoReal := VerificaNull(ValorAno, 0.0) + VerificaNull(ValorMes,0.0) + VerificaNull(ValorDia,0.0); 
        --soma-se o pendente iniciando do primeiro dia do mes;
        saldo := (ValorAtual + ValorPendente) - (ValorComprometidoReal + ValorComprometido);        
    END IF;    
END;$$
    LANGUAGE plpgsql;
 k   DROP FUNCTION public.retornarsaldo(datasaldo date, produto integer, tiposaldo integer, OUT saldo numeric);
       public       postgres    false    6    470            )            1255    27511    verificanull(numeric, numeric)    FUNCTION �   CREATE FUNCTION verificanull(valor numeric, retornar numeric) RETURNS numeric
    AS $$BEGIN
    IF (valor ISNULL) THEN
	RETURN retornar;
    ELSE
        RETURN valor;
    END IF;
END;$$
    LANGUAGE plpgsql;
 D   DROP FUNCTION public.verificanull(valor numeric, retornar numeric);
       public       postgres    false    470    6            �           1259    27512    Auditoria_idAuditoria_seq    SEQUENCE l   CREATE SEQUENCE "Auditoria_idAuditoria_seq"
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 2   DROP SEQUENCE public."Auditoria_idAuditoria_seq";
       public       postgres    false    1642    6            �           0    0    Auditoria_idAuditoria_seq    SEQUENCE OWNED BY K   ALTER SEQUENCE "Auditoria_idAuditoria_seq" OWNED BY auditoria.idauditoria;
            public       postgres    false    1686            �           0    0    Auditoria_idAuditoria_seq    SEQUENCE SET C   SELECT pg_catalog.setval('"Auditoria_idAuditoria_seq"', 74, true);
            public       postgres    false    1686            �           1259    27514    botao_idbotao_seq    SEQUENCE b   CREATE SEQUENCE botao_idbotao_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 (   DROP SEQUENCE public.botao_idbotao_seq;
       public       postgres    false    6    1644            �           0    0    botao_idbotao_seq    SEQUENCE OWNED BY 9   ALTER SEQUENCE botao_idbotao_seq OWNED BY botao.idbotao;
            public       postgres    false    1687            �           0    0    botao_idbotao_seq    SEQUENCE SET 8   SELECT pg_catalog.setval('botao_idbotao_seq', 6, true);
            public       postgres    false    1687            �           1259    27516    cardapio_idcardapio_seq    SEQUENCE h   CREATE SEQUENCE cardapio_idcardapio_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 .   DROP SEQUENCE public.cardapio_idcardapio_seq;
       public       postgres    false    6    1646            �           0    0    cardapio_idcardapio_seq    SEQUENCE OWNED BY E   ALTER SEQUENCE cardapio_idcardapio_seq OWNED BY cardapio.idcardapio;
            public       postgres    false    1688            �           0    0    cardapio_idcardapio_seq    SEQUENCE SET ?   SELECT pg_catalog.setval('cardapio_idcardapio_seq', 11, true);
            public       postgres    false    1688            �           1259    36242 !   cardapioordem_idcardapioordem_seq    SEQUENCE r   CREATE SEQUENCE cardapioordem_idcardapioordem_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 8   DROP SEQUENCE public.cardapioordem_idcardapioordem_seq;
       public       postgres    false    1740    6            �           0    0 !   cardapioordem_idcardapioordem_seq    SEQUENCE OWNED BY Y   ALTER SEQUENCE cardapioordem_idcardapioordem_seq OWNED BY cardapioordem.idcardapioordem;
            public       postgres    false    1739            �           0    0 !   cardapioordem_idcardapioordem_seq    SEQUENCE SET H   SELECT pg_catalog.setval('cardapioordem_idcardapioordem_seq', 6, true);
            public       postgres    false    1739            �           1259    36260 #   cardapiopedido_idcardapiopedido_seq    SEQUENCE t   CREATE SEQUENCE cardapiopedido_idcardapiopedido_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 :   DROP SEQUENCE public.cardapiopedido_idcardapiopedido_seq;
       public       postgres    false    6    1742            �           0    0 #   cardapiopedido_idcardapiopedido_seq    SEQUENCE OWNED BY ]   ALTER SEQUENCE cardapiopedido_idcardapiopedido_seq OWNED BY cardapiopedido.idcardapiopedido;
            public       postgres    false    1741            �           0    0 #   cardapiopedido_idcardapiopedido_seq    SEQUENCE SET J   SELECT pg_catalog.setval('cardapiopedido_idcardapiopedido_seq', 4, true);
            public       postgres    false    1741            �           1259    36219 '   cardapiosituacao_idcardapiosituacao_seq    SEQUENCE x   CREATE SEQUENCE cardapiosituacao_idcardapiosituacao_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 >   DROP SEQUENCE public.cardapiosituacao_idcardapiosituacao_seq;
       public       postgres    false    1738    6            �           0    0 '   cardapiosituacao_idcardapiosituacao_seq    SEQUENCE OWNED BY e   ALTER SEQUENCE cardapiosituacao_idcardapiosituacao_seq OWNED BY cardapiosituacao.idcardapiosituacao;
            public       postgres    false    1737            �           0    0 '   cardapiosituacao_idcardapiosituacao_seq    SEQUENCE SET N   SELECT pg_catalog.setval('cardapiosituacao_idcardapiosituacao_seq', 8, true);
            public       postgres    false    1737            �           1259    27518    cargo_idcargo_seq    SEQUENCE b   CREATE SEQUENCE cargo_idcargo_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 (   DROP SEQUENCE public.cargo_idcargo_seq;
       public       postgres    false    1648    6            �           0    0    cargo_idcargo_seq    SEQUENCE OWNED BY 9   ALTER SEQUENCE cargo_idcargo_seq OWNED BY cargo.idcargo;
            public       postgres    false    1689            �           0    0    cargo_idcargo_seq    SEQUENCE SET 9   SELECT pg_catalog.setval('cargo_idcargo_seq', 50, true);
            public       postgres    false    1689            �           1259    27520 /   composicaocentesimal_idcomposicaocentesimal_seq    SEQUENCE �   CREATE SEQUENCE composicaocentesimal_idcomposicaocentesimal_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 F   DROP SEQUENCE public.composicaocentesimal_idcomposicaocentesimal_seq;
       public       postgres    false    1649    6            �           0    0 /   composicaocentesimal_idcomposicaocentesimal_seq    SEQUENCE OWNED BY u   ALTER SEQUENCE composicaocentesimal_idcomposicaocentesimal_seq OWNED BY composicaocentesimal.idcomposicaocentesimal;
            public       postgres    false    1690            �           0    0 /   composicaocentesimal_idcomposicaocentesimal_seq    SEQUENCE SET W   SELECT pg_catalog.setval('composicaocentesimal_idcomposicaocentesimal_seq', 22, true);
            public       postgres    false    1690            �           1259    27522 #   dadosbancarios_iddadosbancarios_seq    SEQUENCE t   CREATE SEQUENCE dadosbancarios_iddadosbancarios_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 :   DROP SEQUENCE public.dadosbancarios_iddadosbancarios_seq;
       public       postgres    false    1650    6            �           0    0 #   dadosbancarios_iddadosbancarios_seq    SEQUENCE OWNED BY ]   ALTER SEQUENCE dadosbancarios_iddadosbancarios_seq OWNED BY dadosbancarios.iddadosbancarios;
            public       postgres    false    1691             	           0    0 #   dadosbancarios_iddadosbancarios_seq    SEQUENCE SET K   SELECT pg_catalog.setval('dadosbancarios_iddadosbancarios_seq', 12, true);
            public       postgres    false    1691            �           1259    27524    email_idemail_seq    SEQUENCE b   CREATE SEQUENCE email_idemail_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 (   DROP SEQUENCE public.email_idemail_seq;
       public       postgres    false    6    1651            	           0    0    email_idemail_seq    SEQUENCE OWNED BY 9   ALTER SEQUENCE email_idemail_seq OWNED BY email.idemail;
            public       postgres    false    1692            	           0    0    email_idemail_seq    SEQUENCE SET 8   SELECT pg_catalog.setval('email_idemail_seq', 9, true);
            public       postgres    false    1692            �           1259    27526    fichatecnica_idfichatecnica_seq    SEQUENCE p   CREATE SEQUENCE fichatecnica_idfichatecnica_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 6   DROP SEQUENCE public.fichatecnica_idfichatecnica_seq;
       public       postgres    false    1652    6            	           0    0    fichatecnica_idfichatecnica_seq    SEQUENCE OWNED BY U   ALTER SEQUENCE fichatecnica_idfichatecnica_seq OWNED BY fichatecnica.idfichatecnica;
            public       postgres    false    1693            	           0    0    fichatecnica_idfichatecnica_seq    SEQUENCE SET F   SELECT pg_catalog.setval('fichatecnica_idfichatecnica_seq', 9, true);
            public       postgres    false    1693            �           1259    27528 #   formapagamento_idformapagamento_seq    SEQUENCE t   CREATE SEQUENCE formapagamento_idformapagamento_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 :   DROP SEQUENCE public.formapagamento_idformapagamento_seq;
       public       postgres    false    6    1654            	           0    0 #   formapagamento_idformapagamento_seq    SEQUENCE OWNED BY ]   ALTER SEQUENCE formapagamento_idformapagamento_seq OWNED BY formapagamento.idformapagamento;
            public       postgres    false    1694            	           0    0 #   formapagamento_idformapagamento_seq    SEQUENCE SET J   SELECT pg_catalog.setval('formapagamento_idformapagamento_seq', 8, true);
            public       postgres    false    1694            �           1259    27530 7   formapagamentofornecedor_idformapagamentofornecedor_seq    SEQUENCE �   CREATE SEQUENCE formapagamentofornecedor_idformapagamentofornecedor_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 N   DROP SEQUENCE public.formapagamentofornecedor_idformapagamentofornecedor_seq;
       public       postgres    false    6    1655            	           0    0 7   formapagamentofornecedor_idformapagamentofornecedor_seq    SEQUENCE OWNED BY �   ALTER SEQUENCE formapagamentofornecedor_idformapagamentofornecedor_seq OWNED BY formapagamentofornecedor.idformapagamentofornecedor;
            public       postgres    false    1695            	           0    0 7   formapagamentofornecedor_idformapagamentofornecedor_seq    SEQUENCE SET ^   SELECT pg_catalog.setval('formapagamentofornecedor_idformapagamentofornecedor_seq', 5, true);
            public       postgres    false    1695            �           1259    27532    fornecedor_idfornecedor_seq    SEQUENCE l   CREATE SEQUENCE fornecedor_idfornecedor_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 2   DROP SEQUENCE public.fornecedor_idfornecedor_seq;
       public       postgres    false    1656    6            		           0    0    fornecedor_idfornecedor_seq    SEQUENCE OWNED BY M   ALTER SEQUENCE fornecedor_idfornecedor_seq OWNED BY fornecedor.idfornecedor;
            public       postgres    false    1696            
	           0    0    fornecedor_idfornecedor_seq    SEQUENCE SET C   SELECT pg_catalog.setval('fornecedor_idfornecedor_seq', 20, true);
            public       postgres    false    1696            �           1259    27534 )   fornecedorproduto_idfornecedorproduto_seq    SEQUENCE z   CREATE SEQUENCE fornecedorproduto_idfornecedorproduto_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 @   DROP SEQUENCE public.fornecedorproduto_idfornecedorproduto_seq;
       public       postgres    false    6    1657            	           0    0 )   fornecedorproduto_idfornecedorproduto_seq    SEQUENCE OWNED BY i   ALTER SEQUENCE fornecedorproduto_idfornecedorproduto_seq OWNED BY fornecedorproduto.idfornecedorproduto;
            public       postgres    false    1697            	           0    0 )   fornecedorproduto_idfornecedorproduto_seq    SEQUENCE SET Q   SELECT pg_catalog.setval('fornecedorproduto_idfornecedorproduto_seq', 13, true);
            public       postgres    false    1697            �           1259    27894 %   historicopedido_idhistoricopedido_seq    SEQUENCE v   CREATE SEQUENCE historicopedido_idhistoricopedido_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 <   DROP SEQUENCE public.historicopedido_idhistoricopedido_seq;
       public       postgres    false    6    1727            	           0    0 %   historicopedido_idhistoricopedido_seq    SEQUENCE OWNED BY a   ALTER SEQUENCE historicopedido_idhistoricopedido_seq OWNED BY historicopedido.idhistoricopedido;
            public       postgres    false    1726            	           0    0 %   historicopedido_idhistoricopedido_seq    SEQUENCE SET M   SELECT pg_catalog.setval('historicopedido_idhistoricopedido_seq', 43, true);
            public       postgres    false    1726            �           1259    27943 !   itemavaliacao_iditemavaliacao_seq    SEQUENCE r   CREATE SEQUENCE itemavaliacao_iditemavaliacao_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 8   DROP SEQUENCE public.itemavaliacao_iditemavaliacao_seq;
       public       postgres    false    6    1731            	           0    0 !   itemavaliacao_iditemavaliacao_seq    SEQUENCE OWNED BY Y   ALTER SEQUENCE itemavaliacao_iditemavaliacao_seq OWNED BY itemavaliacao.iditemavaliacao;
            public       postgres    false    1730            	           0    0 !   itemavaliacao_iditemavaliacao_seq    SEQUENCE SET I   SELECT pg_catalog.setval('itemavaliacao_iditemavaliacao_seq', 51, true);
            public       postgres    false    1730            �           1259    27912    itempedido_iditempedido_seq    SEQUENCE l   CREATE SEQUENCE itempedido_iditempedido_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 2   DROP SEQUENCE public.itempedido_iditempedido_seq;
       public       postgres    false    1729    6            	           0    0    itempedido_iditempedido_seq    SEQUENCE OWNED BY M   ALTER SEQUENCE itempedido_iditempedido_seq OWNED BY itempedido.iditempedido;
            public       postgres    false    1728            	           0    0    itempedido_iditempedido_seq    SEQUENCE SET C   SELECT pg_catalog.setval('itempedido_iditempedido_seq', 66, true);
            public       postgres    false    1728            �           1259    27536    logsistema_idlogsistema_seq    SEQUENCE l   CREATE SEQUENCE logsistema_idlogsistema_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 2   DROP SEQUENCE public.logsistema_idlogsistema_seq;
       public       postgres    false    1659    6            	           0    0    logsistema_idlogsistema_seq    SEQUENCE OWNED BY M   ALTER SEQUENCE logsistema_idlogsistema_seq OWNED BY logsistema.idlogsistema;
            public       postgres    false    1698            	           0    0    logsistema_idlogsistema_seq    SEQUENCE SET E   SELECT pg_catalog.setval('logsistema_idlogsistema_seq', 1902, true);
            public       postgres    false    1698            �           1259    27538    mensagens_idmensagem_seq    SEQUENCE i   CREATE SEQUENCE mensagens_idmensagem_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 /   DROP SEQUENCE public.mensagens_idmensagem_seq;
       public       postgres    false    6    1660            	           0    0    mensagens_idmensagem_seq    SEQUENCE OWNED BY G   ALTER SEQUENCE mensagens_idmensagem_seq OWNED BY mensagens.idmensagem;
            public       postgres    false    1699            	           0    0    mensagens_idmensagem_seq    SEQUENCE SET @   SELECT pg_catalog.setval('mensagens_idmensagem_seq', 11, true);
            public       postgres    false    1699            �           1259    27540    motivo_idmotivo_seq    SEQUENCE d   CREATE SEQUENCE motivo_idmotivo_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 *   DROP SEQUENCE public.motivo_idmotivo_seq;
       public       postgres    false    1661    6            	           0    0    motivo_idmotivo_seq    SEQUENCE OWNED BY =   ALTER SEQUENCE motivo_idmotivo_seq OWNED BY motivo.idmotivo;
            public       postgres    false    1700            	           0    0    motivo_idmotivo_seq    SEQUENCE SET ;   SELECT pg_catalog.setval('motivo_idmotivo_seq', 11, true);
            public       postgres    false    1700            �           1259    27542    movimento_idmovimento_seq    SEQUENCE j   CREATE SEQUENCE movimento_idmovimento_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 0   DROP SEQUENCE public.movimento_idmovimento_seq;
       public       postgres    false    6    1662            	           0    0    movimento_idmovimento_seq    SEQUENCE OWNED BY I   ALTER SEQUENCE movimento_idmovimento_seq OWNED BY movimento.idmovimento;
            public       postgres    false    1701            	           0    0    movimento_idmovimento_seq    SEQUENCE SET A   SELECT pg_catalog.setval('movimento_idmovimento_seq', 34, true);
            public       postgres    false    1701            �           1259    27544    operacao_idoperacao_seq    SEQUENCE y   CREATE SEQUENCE operacao_idoperacao_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 .   DROP SEQUENCE public.operacao_idoperacao_seq;
       public       postgres    false    6    1663            	           0    0    operacao_idoperacao_seq    SEQUENCE OWNED BY E   ALTER SEQUENCE operacao_idoperacao_seq OWNED BY operacao.idoperacao;
            public       postgres    false    1702            	           0    0    operacao_idoperacao_seq    SEQUENCE SET ?   SELECT pg_catalog.setval('operacao_idoperacao_seq', 1, false);
            public       postgres    false    1702            �           1259    27546 !   ordemproducao_idordemproducao_seq    SEQUENCE r   CREATE SEQUENCE ordemproducao_idordemproducao_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 8   DROP SEQUENCE public.ordemproducao_idordemproducao_seq;
       public       postgres    false    6    1664            	           0    0 !   ordemproducao_idordemproducao_seq    SEQUENCE OWNED BY Y   ALTER SEQUENCE ordemproducao_idordemproducao_seq OWNED BY ordemproducao.idordemproducao;
            public       postgres    false    1703            	           0    0 !   ordemproducao_idordemproducao_seq    SEQUENCE SET I   SELECT pg_catalog.setval('ordemproducao_idordemproducao_seq', 75, true);
            public       postgres    false    1703            �           1259    27548    ordemproduto_idordemproduto_seq    SEQUENCE p   CREATE SEQUENCE ordemproduto_idordemproduto_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 6   DROP SEQUENCE public.ordemproduto_idordemproduto_seq;
       public       postgres    false    6    1665            	           0    0    ordemproduto_idordemproduto_seq    SEQUENCE OWNED BY U   ALTER SEQUENCE ordemproduto_idordemproduto_seq OWNED BY ordemproduto.idordemproduto;
            public       postgres    false    1704             	           0    0    ordemproduto_idordemproduto_seq    SEQUENCE SET H   SELECT pg_catalog.setval('ordemproduto_idordemproduto_seq', 138, true);
            public       postgres    false    1704            �           1259    27550    origemordem_idorigemordem_seq    SEQUENCE    CREATE SEQUENCE origemordem_idorigemordem_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 4   DROP SEQUENCE public.origemordem_idorigemordem_seq;
       public       postgres    false    6    1666            !	           0    0    origemordem_idorigemordem_seq    SEQUENCE OWNED BY Q   ALTER SEQUENCE origemordem_idorigemordem_seq OWNED BY origemordem.idorigemordem;
            public       postgres    false    1705            "	           0    0    origemordem_idorigemordem_seq    SEQUENCE SET E   SELECT pg_catalog.setval('origemordem_idorigemordem_seq', 1, false);
            public       postgres    false    1705            �           1259    27886    pedido_idpedido_seq    SEQUENCE d   CREATE SEQUENCE pedido_idpedido_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 *   DROP SEQUENCE public.pedido_idpedido_seq;
       public       postgres    false    6    1725            #	           0    0    pedido_idpedido_seq    SEQUENCE OWNED BY =   ALTER SEQUENCE pedido_idpedido_seq OWNED BY pedido.idpedido;
            public       postgres    false    1724            $	           0    0    pedido_idpedido_seq    SEQUENCE SET ;   SELECT pg_catalog.setval('pedido_idpedido_seq', 43, true);
            public       postgres    false    1724            �           1259    27552    perfil_idperfil_seq    SEQUENCE d   CREATE SEQUENCE perfil_idperfil_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 *   DROP SEQUENCE public.perfil_idperfil_seq;
       public       postgres    false    6    1667            %	           0    0    perfil_idperfil_seq    SEQUENCE OWNED BY =   ALTER SEQUENCE perfil_idperfil_seq OWNED BY perfil.idperfil;
            public       postgres    false    1706            &	           0    0    perfil_idperfil_seq    SEQUENCE SET ;   SELECT pg_catalog.setval('perfil_idperfil_seq', 25, true);
            public       postgres    false    1706            �           1259    27554    perfiltela_idperfiltela_seq    SEQUENCE l   CREATE SEQUENCE perfiltela_idperfiltela_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 2   DROP SEQUENCE public.perfiltela_idperfiltela_seq;
       public       postgres    false    1668    6            '	           0    0    perfiltela_idperfiltela_seq    SEQUENCE OWNED BY M   ALTER SEQUENCE perfiltela_idperfiltela_seq OWNED BY perfiltela.idperfiltela;
            public       postgres    false    1707            (	           0    0    perfiltela_idperfiltela_seq    SEQUENCE SET C   SELECT pg_catalog.setval('perfiltela_idperfiltela_seq', 79, true);
            public       postgres    false    1707            �           1259    27556    produto_idproduto_seq    SEQUENCE f   CREATE SEQUENCE produto_idproduto_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.produto_idproduto_seq;
       public       postgres    false    1669    6            )	           0    0    produto_idproduto_seq    SEQUENCE OWNED BY A   ALTER SEQUENCE produto_idproduto_seq OWNED BY produto.idproduto;
            public       postgres    false    1708            *	           0    0    produto_idproduto_seq    SEQUENCE SET =   SELECT pg_catalog.setval('produto_idproduto_seq', 19, true);
            public       postgres    false    1708            �           1259    27558    refeicao_idrefeicao_seq    SEQUENCE h   CREATE SEQUENCE refeicao_idrefeicao_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 .   DROP SEQUENCE public.refeicao_idrefeicao_seq;
       public       postgres    false    1671    6            +	           0    0    refeicao_idrefeicao_seq    SEQUENCE OWNED BY E   ALTER SEQUENCE refeicao_idrefeicao_seq OWNED BY refeicao.idrefeicao;
            public       postgres    false    1709            ,	           0    0    refeicao_idrefeicao_seq    SEQUENCE SET >   SELECT pg_catalog.setval('refeicao_idrefeicao_seq', 7, true);
            public       postgres    false    1709            �           1259    27560    saldoano_idano_seq    SEQUENCE c   CREATE SEQUENCE saldoano_idano_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 )   DROP SEQUENCE public.saldoano_idano_seq;
       public       postgres    false    1672    6            -	           0    0    saldoano_idano_seq    SEQUENCE OWNED BY @   ALTER SEQUENCE saldoano_idano_seq OWNED BY saldoano.idsaldoano;
            public       postgres    false    1710            .	           0    0    saldoano_idano_seq    SEQUENCE SET ;   SELECT pg_catalog.setval('saldoano_idano_seq', 113, true);
            public       postgres    false    1710            �           1259    27562    saldodia_idsaldodia_seq    SEQUENCE h   CREATE SEQUENCE saldodia_idsaldodia_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 .   DROP SEQUENCE public.saldodia_idsaldodia_seq;
       public       postgres    false    1673    6            /	           0    0    saldodia_idsaldodia_seq    SEQUENCE OWNED BY E   ALTER SEQUENCE saldodia_idsaldodia_seq OWNED BY saldodia.idsaldodia;
            public       postgres    false    1711            0	           0    0    saldodia_idsaldodia_seq    SEQUENCE SET @   SELECT pg_catalog.setval('saldodia_idsaldodia_seq', 184, true);
            public       postgres    false    1711            �           1259    27564    saldomes_idsaldomes_seq    SEQUENCE h   CREATE SEQUENCE saldomes_idsaldomes_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 .   DROP SEQUENCE public.saldomes_idsaldomes_seq;
       public       postgres    false    1674    6            1	           0    0    saldomes_idsaldomes_seq    SEQUENCE OWNED BY E   ALTER SEQUENCE saldomes_idsaldomes_seq OWNED BY saldomes.idsaldomes;
            public       postgres    false    1712            2	           0    0    saldomes_idsaldomes_seq    SEQUENCE SET @   SELECT pg_catalog.setval('saldomes_idsaldomes_seq', 157, true);
            public       postgres    false    1712            �           1259    36211 '   situacaocardapio_idsituacaocardapio_seq    SEQUENCE x   CREATE SEQUENCE situacaocardapio_idsituacaocardapio_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 >   DROP SEQUENCE public.situacaocardapio_idsituacaocardapio_seq;
       public       postgres    false    1736    6            3	           0    0 '   situacaocardapio_idsituacaocardapio_seq    SEQUENCE OWNED BY e   ALTER SEQUENCE situacaocardapio_idsituacaocardapio_seq OWNED BY situacaocardapio.idsituacaocardapio;
            public       postgres    false    1735            4	           0    0 '   situacaocardapio_idsituacaocardapio_seq    SEQUENCE SET N   SELECT pg_catalog.setval('situacaocardapio_idsituacaocardapio_seq', 4, true);
            public       postgres    false    1735            �           1259    36186 +   situacaoitempedido_idsituacaoitempedido_seq    SEQUENCE �   CREATE SEQUENCE situacaoitempedido_idsituacaoitempedido_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 B   DROP SEQUENCE public.situacaoitempedido_idsituacaoitempedido_seq;
       public       postgres    false    6    1734            5	           0    0 +   situacaoitempedido_idsituacaoitempedido_seq    SEQUENCE OWNED BY m   ALTER SEQUENCE situacaoitempedido_idsituacaoitempedido_seq OWNED BY situacaoitempedido.idsituacaoitempedido;
            public       postgres    false    1733            6	           0    0 +   situacaoitempedido_idsituacaoitempedido_seq    SEQUENCE SET S   SELECT pg_catalog.setval('situacaoitempedido_idsituacaoitempedido_seq', 1, false);
            public       postgres    false    1733            �           1259    27566 !   situacaoordem_idsituacaoordem_seq    SEQUENCE �   CREATE SEQUENCE situacaoordem_idsituacaoordem_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 8   DROP SEQUENCE public.situacaoordem_idsituacaoordem_seq;
       public       postgres    false    6    1675            7	           0    0 !   situacaoordem_idsituacaoordem_seq    SEQUENCE OWNED BY Y   ALTER SEQUENCE situacaoordem_idsituacaoordem_seq OWNED BY situacaoordem.idsituacaoordem;
            public       postgres    false    1713            8	           0    0 !   situacaoordem_idsituacaoordem_seq    SEQUENCE SET I   SELECT pg_catalog.setval('situacaoordem_idsituacaoordem_seq', 1, false);
            public       postgres    false    1713            �           1259    27878 #   situacaopedido_idsituacaopedido_seq    SEQUENCE �   CREATE SEQUENCE situacaopedido_idsituacaopedido_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 :   DROP SEQUENCE public.situacaopedido_idsituacaopedido_seq;
       public       postgres    false    1723    6            9	           0    0 #   situacaopedido_idsituacaopedido_seq    SEQUENCE OWNED BY ]   ALTER SEQUENCE situacaopedido_idsituacaopedido_seq OWNED BY situacaopedido.idsituacaopedido;
            public       postgres    false    1722            :	           0    0 #   situacaopedido_idsituacaopedido_seq    SEQUENCE SET K   SELECT pg_catalog.setval('situacaopedido_idsituacaopedido_seq', 1, false);
            public       postgres    false    1722            �           1259    27568    tela_idtela_seq    SEQUENCE `   CREATE SEQUENCE tela_idtela_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 &   DROP SEQUENCE public.tela_idtela_seq;
       public       postgres    false    6    1677            ;	           0    0    tela_idtela_seq    SEQUENCE OWNED BY 5   ALTER SEQUENCE tela_idtela_seq OWNED BY tela.idtela;
            public       postgres    false    1714            <	           0    0    tela_idtela_seq    SEQUENCE SET 6   SELECT pg_catalog.setval('tela_idtela_seq', 9, true);
            public       postgres    false    1714            �           1259    27570    telabotao_idtelabotao_seq    SEQUENCE j   CREATE SEQUENCE telabotao_idtelabotao_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 0   DROP SEQUENCE public.telabotao_idtelabotao_seq;
       public       postgres    false    1678    6            =	           0    0    telabotao_idtelabotao_seq    SEQUENCE OWNED BY I   ALTER SEQUENCE telabotao_idtelabotao_seq OWNED BY telabotao.idtelabotao;
            public       postgres    false    1715            >	           0    0    telabotao_idtelabotao_seq    SEQUENCE SET A   SELECT pg_catalog.setval('telabotao_idtelabotao_seq', 21, true);
            public       postgres    false    1715            �           1259    27572    telefone_idtelefone_seq    SEQUENCE h   CREATE SEQUENCE telefone_idtelefone_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 .   DROP SEQUENCE public.telefone_idtelefone_seq;
       public       postgres    false    1679    6            ?	           0    0    telefone_idtelefone_seq    SEQUENCE OWNED BY E   ALTER SEQUENCE telefone_idtelefone_seq OWNED BY telefone.idtelefone;
            public       postgres    false    1716            @	           0    0    telefone_idtelefone_seq    SEQUENCE SET >   SELECT pg_catalog.setval('telefone_idtelefone_seq', 9, true);
            public       postgres    false    1716            �           1259    27574 #   tipofornecedor_idtipofornecedor_seq    SEQUENCE �   CREATE SEQUENCE tipofornecedor_idtipofornecedor_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 :   DROP SEQUENCE public.tipofornecedor_idtipofornecedor_seq;
       public       postgres    false    6    1680            A	           0    0 #   tipofornecedor_idtipofornecedor_seq    SEQUENCE OWNED BY ]   ALTER SEQUENCE tipofornecedor_idtipofornecedor_seq OWNED BY tipofornecedor.idtipofornecedor;
            public       postgres    false    1717            B	           0    0 #   tipofornecedor_idtipofornecedor_seq    SEQUENCE SET K   SELECT pg_catalog.setval('tipofornecedor_idtipofornecedor_seq', 1, false);
            public       postgres    false    1717            �           1259    27576    tipotelefone_idtipotelefone_seq    SEQUENCE �   CREATE SEQUENCE tipotelefone_idtipotelefone_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 6   DROP SEQUENCE public.tipotelefone_idtipotelefone_seq;
       public       postgres    false    6    1681            C	           0    0    tipotelefone_idtipotelefone_seq    SEQUENCE OWNED BY U   ALTER SEQUENCE tipotelefone_idtipotelefone_seq OWNED BY tipotelefone.idtipotelefone;
            public       postgres    false    1718            D	           0    0    tipotelefone_idtipotelefone_seq    SEQUENCE SET G   SELECT pg_catalog.setval('tipotelefone_idtipotelefone_seq', 1, false);
            public       postgres    false    1718            �           1259    27578 !   ultimousuario_idultimousuario_seq    SEQUENCE r   CREATE SEQUENCE ultimousuario_idultimousuario_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 8   DROP SEQUENCE public.ultimousuario_idultimousuario_seq;
       public       postgres    false    6    1682            E	           0    0 !   ultimousuario_idultimousuario_seq    SEQUENCE OWNED BY Y   ALTER SEQUENCE ultimousuario_idultimousuario_seq OWNED BY ultimousuario.idultimousuario;
            public       postgres    false    1719            F	           0    0 !   ultimousuario_idultimousuario_seq    SEQUENCE SET H   SELECT pg_catalog.setval('ultimousuario_idultimousuario_seq', 2, true);
            public       postgres    false    1719            �           1259    27580 !   unidademedida_idunidademedida_seq    SEQUENCE r   CREATE SEQUENCE unidademedida_idunidademedida_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 8   DROP SEQUENCE public.unidademedida_idunidademedida_seq;
       public       postgres    false    6    1683            G	           0    0 !   unidademedida_idunidademedida_seq    SEQUENCE OWNED BY Y   ALTER SEQUENCE unidademedida_idunidademedida_seq OWNED BY unidademedida.idunidademedida;
            public       postgres    false    1720            H	           0    0 !   unidademedida_idunidademedida_seq    SEQUENCE SET H   SELECT pg_catalog.setval('unidademedida_idunidademedida_seq', 8, true);
            public       postgres    false    1720            �           1259    27582    usuario_idusuario_seq    SEQUENCE f   CREATE SEQUENCE usuario_idusuario_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.usuario_idusuario_seq;
       public       postgres    false    6    1684            I	           0    0    usuario_idusuario_seq    SEQUENCE OWNED BY A   ALTER SEQUENCE usuario_idusuario_seq OWNED BY usuario.idusuario;
            public       postgres    false    1721            J	           0    0    usuario_idusuario_seq    SEQUENCE SET <   SELECT pg_catalog.setval('usuario_idusuario_seq', 3, true);
            public       postgres    false    1721            �           2604    27584    idauditoria    DEFAULT m   ALTER TABLE auditoria ALTER COLUMN idauditoria SET DEFAULT nextval('"Auditoria_idAuditoria_seq"'::regclass);
 D   ALTER TABLE public.auditoria ALTER COLUMN idauditoria DROP DEFAULT;
       public       postgres    false    1686    1642            �           2604    27585    idbotao    DEFAULT [   ALTER TABLE botao ALTER COLUMN idbotao SET DEFAULT nextval('botao_idbotao_seq'::regclass);
 <   ALTER TABLE public.botao ALTER COLUMN idbotao DROP DEFAULT;
       public       postgres    false    1687    1644            �           2604    27586 
   idcardapio    DEFAULT g   ALTER TABLE cardapio ALTER COLUMN idcardapio SET DEFAULT nextval('cardapio_idcardapio_seq'::regclass);
 B   ALTER TABLE public.cardapio ALTER COLUMN idcardapio DROP DEFAULT;
       public       postgres    false    1688    1646                       2604    36247    idcardapioordem    DEFAULT {   ALTER TABLE cardapioordem ALTER COLUMN idcardapioordem SET DEFAULT nextval('cardapioordem_idcardapioordem_seq'::regclass);
 L   ALTER TABLE public.cardapioordem ALTER COLUMN idcardapioordem DROP DEFAULT;
       public       postgres    false    1739    1740    1740                       2604    36265    idcardapiopedido    DEFAULT    ALTER TABLE cardapiopedido ALTER COLUMN idcardapiopedido SET DEFAULT nextval('cardapiopedido_idcardapiopedido_seq'::regclass);
 N   ALTER TABLE public.cardapiopedido ALTER COLUMN idcardapiopedido DROP DEFAULT;
       public       postgres    false    1741    1742    1742                       2604    36224    idcardapiosituacao    DEFAULT �   ALTER TABLE cardapiosituacao ALTER COLUMN idcardapiosituacao SET DEFAULT nextval('cardapiosituacao_idcardapiosituacao_seq'::regclass);
 R   ALTER TABLE public.cardapiosituacao ALTER COLUMN idcardapiosituacao DROP DEFAULT;
       public       postgres    false    1738    1737    1738            �           2604    27587    idcargo    DEFAULT [   ALTER TABLE cargo ALTER COLUMN idcargo SET DEFAULT nextval('cargo_idcargo_seq'::regclass);
 <   ALTER TABLE public.cargo ALTER COLUMN idcargo DROP DEFAULT;
       public       postgres    false    1689    1648            �           2604    27588    idcomposicaocentesimal    DEFAULT �   ALTER TABLE composicaocentesimal ALTER COLUMN idcomposicaocentesimal SET DEFAULT nextval('composicaocentesimal_idcomposicaocentesimal_seq'::regclass);
 Z   ALTER TABLE public.composicaocentesimal ALTER COLUMN idcomposicaocentesimal DROP DEFAULT;
       public       postgres    false    1690    1649            �           2604    27589    iddadosbancarios    DEFAULT    ALTER TABLE dadosbancarios ALTER COLUMN iddadosbancarios SET DEFAULT nextval('dadosbancarios_iddadosbancarios_seq'::regclass);
 N   ALTER TABLE public.dadosbancarios ALTER COLUMN iddadosbancarios DROP DEFAULT;
       public       postgres    false    1691    1650            �           2604    27590    idemail    DEFAULT [   ALTER TABLE email ALTER COLUMN idemail SET DEFAULT nextval('email_idemail_seq'::regclass);
 <   ALTER TABLE public.email ALTER COLUMN idemail DROP DEFAULT;
       public       postgres    false    1692    1651            �           2604    27591    idfichatecnica    DEFAULT w   ALTER TABLE fichatecnica ALTER COLUMN idfichatecnica SET DEFAULT nextval('fichatecnica_idfichatecnica_seq'::regclass);
 J   ALTER TABLE public.fichatecnica ALTER COLUMN idfichatecnica DROP DEFAULT;
       public       postgres    false    1693    1652            �           2604    27592    idformapagamento    DEFAULT    ALTER TABLE formapagamento ALTER COLUMN idformapagamento SET DEFAULT nextval('formapagamento_idformapagamento_seq'::regclass);
 N   ALTER TABLE public.formapagamento ALTER COLUMN idformapagamento DROP DEFAULT;
       public       postgres    false    1694    1654            �           2604    27593    idformapagamentofornecedor    DEFAULT �   ALTER TABLE formapagamentofornecedor ALTER COLUMN idformapagamentofornecedor SET DEFAULT nextval('formapagamentofornecedor_idformapagamentofornecedor_seq'::regclass);
 b   ALTER TABLE public.formapagamentofornecedor ALTER COLUMN idformapagamentofornecedor DROP DEFAULT;
       public       postgres    false    1695    1655            �           2604    27594    idfornecedor    DEFAULT o   ALTER TABLE fornecedor ALTER COLUMN idfornecedor SET DEFAULT nextval('fornecedor_idfornecedor_seq'::regclass);
 F   ALTER TABLE public.fornecedor ALTER COLUMN idfornecedor DROP DEFAULT;
       public       postgres    false    1696    1656            �           2604    27595    idfornecedorproduto    DEFAULT �   ALTER TABLE fornecedorproduto ALTER COLUMN idfornecedorproduto SET DEFAULT nextval('fornecedorproduto_idfornecedorproduto_seq'::regclass);
 T   ALTER TABLE public.fornecedorproduto ALTER COLUMN idfornecedorproduto DROP DEFAULT;
       public       postgres    false    1697    1657                       2604    27899    idhistoricopedido    DEFAULT �   ALTER TABLE historicopedido ALTER COLUMN idhistoricopedido SET DEFAULT nextval('historicopedido_idhistoricopedido_seq'::regclass);
 P   ALTER TABLE public.historicopedido ALTER COLUMN idhistoricopedido DROP DEFAULT;
       public       postgres    false    1726    1727    1727                       2604    27948    iditemavaliacao    DEFAULT {   ALTER TABLE itemavaliacao ALTER COLUMN iditemavaliacao SET DEFAULT nextval('itemavaliacao_iditemavaliacao_seq'::regclass);
 L   ALTER TABLE public.itemavaliacao ALTER COLUMN iditemavaliacao DROP DEFAULT;
       public       postgres    false    1731    1730    1731                       2604    27987    iditempedido    DEFAULT o   ALTER TABLE itempedido ALTER COLUMN iditempedido SET DEFAULT nextval('itempedido_iditempedido_seq'::regclass);
 F   ALTER TABLE public.itempedido ALTER COLUMN iditempedido DROP DEFAULT;
       public       postgres    false    1729    1728    1729            �           2604    27596    idlogsistema    DEFAULT o   ALTER TABLE logsistema ALTER COLUMN idlogsistema SET DEFAULT nextval('logsistema_idlogsistema_seq'::regclass);
 F   ALTER TABLE public.logsistema ALTER COLUMN idlogsistema DROP DEFAULT;
       public       postgres    false    1698    1659            �           2604    27597 
   idmensagem    DEFAULT i   ALTER TABLE mensagens ALTER COLUMN idmensagem SET DEFAULT nextval('mensagens_idmensagem_seq'::regclass);
 C   ALTER TABLE public.mensagens ALTER COLUMN idmensagem DROP DEFAULT;
       public       postgres    false    1699    1660            �           2604    27598    idmotivo    DEFAULT _   ALTER TABLE motivo ALTER COLUMN idmotivo SET DEFAULT nextval('motivo_idmotivo_seq'::regclass);
 >   ALTER TABLE public.motivo ALTER COLUMN idmotivo DROP DEFAULT;
       public       postgres    false    1700    1661            �           2604    27599    idmovimento    DEFAULT k   ALTER TABLE movimento ALTER COLUMN idmovimento SET DEFAULT nextval('movimento_idmovimento_seq'::regclass);
 D   ALTER TABLE public.movimento ALTER COLUMN idmovimento DROP DEFAULT;
       public       postgres    false    1701    1662            �           2604    27600 
   idoperacao    DEFAULT g   ALTER TABLE operacao ALTER COLUMN idoperacao SET DEFAULT nextval('operacao_idoperacao_seq'::regclass);
 B   ALTER TABLE public.operacao ALTER COLUMN idoperacao DROP DEFAULT;
       public       postgres    false    1702    1663            �           2604    27601    idordemproducao    DEFAULT {   ALTER TABLE ordemproducao ALTER COLUMN idordemproducao SET DEFAULT nextval('ordemproducao_idordemproducao_seq'::regclass);
 L   ALTER TABLE public.ordemproducao ALTER COLUMN idordemproducao DROP DEFAULT;
       public       postgres    false    1703    1664            �           2604    27602    idordemproduto    DEFAULT w   ALTER TABLE ordemproduto ALTER COLUMN idordemproduto SET DEFAULT nextval('ordemproduto_idordemproduto_seq'::regclass);
 J   ALTER TABLE public.ordemproduto ALTER COLUMN idordemproduto DROP DEFAULT;
       public       postgres    false    1704    1665            �           2604    27603    idorigemordem    DEFAULT s   ALTER TABLE origemordem ALTER COLUMN idorigemordem SET DEFAULT nextval('origemordem_idorigemordem_seq'::regclass);
 H   ALTER TABLE public.origemordem ALTER COLUMN idorigemordem DROP DEFAULT;
       public       postgres    false    1705    1666                       2604    27891    idpedido    DEFAULT _   ALTER TABLE pedido ALTER COLUMN idpedido SET DEFAULT nextval('pedido_idpedido_seq'::regclass);
 >   ALTER TABLE public.pedido ALTER COLUMN idpedido DROP DEFAULT;
       public       postgres    false    1725    1724    1725            �           2604    27604    idperfil    DEFAULT _   ALTER TABLE perfil ALTER COLUMN idperfil SET DEFAULT nextval('perfil_idperfil_seq'::regclass);
 >   ALTER TABLE public.perfil ALTER COLUMN idperfil DROP DEFAULT;
       public       postgres    false    1706    1667            �           2604    27605    idperfiltela    DEFAULT o   ALTER TABLE perfiltela ALTER COLUMN idperfiltela SET DEFAULT nextval('perfiltela_idperfiltela_seq'::regclass);
 F   ALTER TABLE public.perfiltela ALTER COLUMN idperfiltela DROP DEFAULT;
       public       postgres    false    1707    1668            �           2604    27606 	   idproduto    DEFAULT c   ALTER TABLE produto ALTER COLUMN idproduto SET DEFAULT nextval('produto_idproduto_seq'::regclass);
 @   ALTER TABLE public.produto ALTER COLUMN idproduto DROP DEFAULT;
       public       postgres    false    1708    1669            �           2604    27607 
   idrefeicao    DEFAULT g   ALTER TABLE refeicao ALTER COLUMN idrefeicao SET DEFAULT nextval('refeicao_idrefeicao_seq'::regclass);
 B   ALTER TABLE public.refeicao ALTER COLUMN idrefeicao DROP DEFAULT;
       public       postgres    false    1709    1671            �           2604    27608 
   idsaldoano    DEFAULT b   ALTER TABLE saldoano ALTER COLUMN idsaldoano SET DEFAULT nextval('saldoano_idano_seq'::regclass);
 B   ALTER TABLE public.saldoano ALTER COLUMN idsaldoano DROP DEFAULT;
       public       postgres    false    1710    1672            �           2604    27609 
   idsaldodia    DEFAULT g   ALTER TABLE saldodia ALTER COLUMN idsaldodia SET DEFAULT nextval('saldodia_idsaldodia_seq'::regclass);
 B   ALTER TABLE public.saldodia ALTER COLUMN idsaldodia DROP DEFAULT;
       public       postgres    false    1711    1673                       2604    27610 
   idsaldomes    DEFAULT g   ALTER TABLE saldomes ALTER COLUMN idsaldomes SET DEFAULT nextval('saldomes_idsaldomes_seq'::regclass);
 B   ALTER TABLE public.saldomes ALTER COLUMN idsaldomes DROP DEFAULT;
       public       postgres    false    1712    1674                       2604    36216    idsituacaocardapio    DEFAULT �   ALTER TABLE situacaocardapio ALTER COLUMN idsituacaocardapio SET DEFAULT nextval('situacaocardapio_idsituacaocardapio_seq'::regclass);
 R   ALTER TABLE public.situacaocardapio ALTER COLUMN idsituacaocardapio DROP DEFAULT;
       public       postgres    false    1736    1735    1736                       2604    36191    idsituacaoitempedido    DEFAULT �   ALTER TABLE situacaoitempedido ALTER COLUMN idsituacaoitempedido SET DEFAULT nextval('situacaoitempedido_idsituacaoitempedido_seq'::regclass);
 V   ALTER TABLE public.situacaoitempedido ALTER COLUMN idsituacaoitempedido DROP DEFAULT;
       public       postgres    false    1734    1733    1734                       2604    27611    idsituacaoordem    DEFAULT {   ALTER TABLE situacaoordem ALTER COLUMN idsituacaoordem SET DEFAULT nextval('situacaoordem_idsituacaoordem_seq'::regclass);
 L   ALTER TABLE public.situacaoordem ALTER COLUMN idsituacaoordem DROP DEFAULT;
       public       postgres    false    1713    1675                       2604    27883    idsituacaopedido    DEFAULT    ALTER TABLE situacaopedido ALTER COLUMN idsituacaopedido SET DEFAULT nextval('situacaopedido_idsituacaopedido_seq'::regclass);
 N   ALTER TABLE public.situacaopedido ALTER COLUMN idsituacaopedido DROP DEFAULT;
       public       postgres    false    1722    1723    1723                       2604    27612    idtela    DEFAULT W   ALTER TABLE tela ALTER COLUMN idtela SET DEFAULT nextval('tela_idtela_seq'::regclass);
 :   ALTER TABLE public.tela ALTER COLUMN idtela DROP DEFAULT;
       public       postgres    false    1714    1677                       2604    27613    idtelabotao    DEFAULT k   ALTER TABLE telabotao ALTER COLUMN idtelabotao SET DEFAULT nextval('telabotao_idtelabotao_seq'::regclass);
 D   ALTER TABLE public.telabotao ALTER COLUMN idtelabotao DROP DEFAULT;
       public       postgres    false    1715    1678                       2604    27614 
   idtelefone    DEFAULT g   ALTER TABLE telefone ALTER COLUMN idtelefone SET DEFAULT nextval('telefone_idtelefone_seq'::regclass);
 B   ALTER TABLE public.telefone ALTER COLUMN idtelefone DROP DEFAULT;
       public       postgres    false    1716    1679                       2604    27615    idtipofornecedor    DEFAULT    ALTER TABLE tipofornecedor ALTER COLUMN idtipofornecedor SET DEFAULT nextval('tipofornecedor_idtipofornecedor_seq'::regclass);
 N   ALTER TABLE public.tipofornecedor ALTER COLUMN idtipofornecedor DROP DEFAULT;
       public       postgres    false    1717    1680                       2604    27616    idtipotelefone    DEFAULT w   ALTER TABLE tipotelefone ALTER COLUMN idtipotelefone SET DEFAULT nextval('tipotelefone_idtipotelefone_seq'::regclass);
 J   ALTER TABLE public.tipotelefone ALTER COLUMN idtipotelefone DROP DEFAULT;
       public       postgres    false    1718    1681            	           2604    27617    idultimousuario    DEFAULT {   ALTER TABLE ultimousuario ALTER COLUMN idultimousuario SET DEFAULT nextval('ultimousuario_idultimousuario_seq'::regclass);
 L   ALTER TABLE public.ultimousuario ALTER COLUMN idultimousuario DROP DEFAULT;
       public       postgres    false    1719    1682            
           2604    27618    idunidademedida    DEFAULT {   ALTER TABLE unidademedida ALTER COLUMN idunidademedida SET DEFAULT nextval('unidademedida_idunidademedida_seq'::regclass);
 L   ALTER TABLE public.unidademedida ALTER COLUMN idunidademedida DROP DEFAULT;
       public       postgres    false    1720    1683                       2604    27619 	   idusuario    DEFAULT c   ALTER TABLE usuario ALTER COLUMN idusuario SET DEFAULT nextval('usuario_idusuario_seq'::regclass);
 @   ALTER TABLE public.usuario ALTER COLUMN idusuario DROP DEFAULT;
       public       postgres    false    1721    1684            �          0    27337 	   auditoria 
   TABLE DATA           c   COPY auditoria (idauditoria, dataoperacao, log, operacao, dados, tabela, idreferencia) FROM stdin;
    public       postgres    false    1642            �          0    27343    banco 
   TABLE DATA           '   COPY banco (nome, idbanco) FROM stdin;
    public       postgres    false    1643            �          0    27346    botao 
   TABLE DATA           I   COPY botao (idbotao, titulobotao, nomebotao, descricaobotao) FROM stdin;
    public       postgres    false    1644            �          0    27352    cardapio 
   TABLE DATA           P   COPY cardapio (idcardapio, datacardapio, qtderefeicoes, idrefeicao) FROM stdin;
    public       postgres    false    1646            �          0    27355    cardapioficha 
   TABLE DATA           <   COPY cardapioficha (idcardapio, idfichatecnica) FROM stdin;
    public       postgres    false    1647            �          0    36244    cardapioordem 
   TABLE DATA           N   COPY cardapioordem (idcardapioordem, idcardapio, idordemproducao) FROM stdin;
    public       postgres    false    1740            �          0    36262    cardapiopedido 
   TABLE DATA           I   COPY cardapiopedido (idcardapiopedido, idcardapio, idpedido) FROM stdin;
    public       postgres    false    1742            �          0    36221    cardapiosituacao 
   TABLE DATA           e   COPY cardapiosituacao (idcardapiosituacao, idcardapio, idsituacaocardapio, datasituacao) FROM stdin;
    public       postgres    false    1738            �          0    27358    cargo 
   TABLE DATA           ,   COPY cargo (idcargo, descricao) FROM stdin;
    public       postgres    false    1648            �          0    27361    composicaocentesimal 
   TABLE DATA           �   COPY composicaocentesimal (idcomposicaocentesimal, energia, carboidrato, proteina, lipideo, calcio, ferro, vitaminac) FROM stdin;
    public       postgres    false    1649            �          0    27988    configuracoes 
   TABLE DATA           b   COPY configuracoes (remetente, senha, textomensagem, titulomensagem, idconfiguracoes) FROM stdin;
    public       postgres    false    1732            �          0    27364    dadosbancarios 
   TABLE DATA           i   COPY dadosbancarios (iddadosbancarios, idbanco, agencia, contacorrente, contacorrentedigito) FROM stdin;
    public       postgres    false    1650            �          0    27367    email 
   TABLE DATA           6   COPY email (idemail, email, idfornecedor) FROM stdin;
    public       postgres    false    1651            �          0    27370    fichatecnica 
   TABLE DATA           �   COPY fichatecnica (idfichatecnica, nomepreparacao, modopreparo, rendimento, energia, carboidrato, proteina, lipideo, calcio, ferro, vitaminac, pesocru, pesoliquido, precototal) FROM stdin;
    public       postgres    false    1652            �          0    27373    fichatecnicaitens 
   TABLE DATA           f   COPY fichatecnicaitens (idfichatecnica, idproduto, pesobruto, pesoliquido, fatorcorrecao) FROM stdin;
    public       postgres    false    1653            �          0    27376    formapagamento 
   TABLE DATA           K   COPY formapagamento (idformapagamento, nome, operacaobancaria) FROM stdin;
    public       postgres    false    1654            �          0    27379    formapagamentofornecedor 
   TABLE DATA           g   COPY formapagamentofornecedor (idformapagamentofornecedor, idformapagamento, idfornecedor) FROM stdin;
    public       postgres    false    1655            �          0    27382 
   fornecedor 
   TABLE DATA           �   COPY fornecedor (idfornecedor, codigo, razaosocial, cnpj, inscricaoestadual, ccm, cgc, rua, numero, bairro, cidade, cep, site, tempoentrega, iddadosbancarios) FROM stdin;
    public       postgres    false    1656            �          0    27386    fornecedorproduto 
   TABLE DATA           �   COPY fornecedorproduto (idfornecedorproduto, idproduto, idfornecedor, codprodutofornecedor, tempoentrega, idtipofornecedor, preco) FROM stdin;
    public       postgres    false    1657            �          0    27896    historicopedido 
   TABLE DATA           f   COPY historicopedido (idhistoricopedido, idpedido, idsituacaopedido, datahistoricopedido) FROM stdin;
    public       postgres    false    1727            �          0    27945    itemavaliacao 
   TABLE DATA           x   COPY itemavaliacao (iditemavaliacao, iditempedido, idmotivo, idsituacaoitempedido, adequado, dataavaliacao) FROM stdin;
    public       postgres    false    1731            �          0    27914 
   itempedido 
   TABLE DATA           ]   COPY itempedido (iditempedido, idpedido, idproduto, quantidade, idunidademedida) FROM stdin;
    public       postgres    false    1729            �          0    27392 
   logsistema 
   TABLE DATA           W   COPY logsistema (horario, operacao, logvinculado, idlogsistema, idusuario) FROM stdin;
    public       postgres    false    1659            �          0    27395 	   mensagens 
   TABLE DATA           @   COPY mensagens (idmensagem, mensagem, tipomensagem) FROM stdin;
    public       postgres    false    1660            �          0    27399    motivo 
   TABLE DATA           1   COPY motivo (idmotivo, nome, baixar) FROM stdin;
    public       postgres    false    1661            �          0    27402 	   movimento 
   TABLE DATA           |   COPY movimento (idmovimento, idproduto, quantidade, idunidademedida, idoperacao, motivooperacao, datamovimento) FROM stdin;
    public       postgres    false    1662            �          0    27405    operacao 
   TABLE DATA           ;   COPY operacao (idoperacao, descricao, vlfator) FROM stdin;
    public       postgres    false    1663            �          0    27408    ordemproducao 
   TABLE DATA           w   COPY ordemproducao (idordemproducao, dataordem, idrefeicao, idorigemordem, idsituacaoordem, setor, motivo) FROM stdin;
    public       postgres    false    1664            �          0    27411    ordemproduto 
   TABLE DATA           h   COPY ordemproduto (idordemproducao, idproduto, quantidade, idunidademedida, idordemproduto) FROM stdin;
    public       postgres    false    1665            �          0    27414    origemordem 
   TABLE DATA           8   COPY origemordem (idorigemordem, descricao) FROM stdin;
    public       postgres    false    1666            �          0    27888    pedido 
   TABLE DATA           >   COPY pedido (idpedido, idfornecedor, dataentrega) FROM stdin;
    public       postgres    false    1725            �          0    27417    perfil 
   TABLE DATA           8   COPY perfil (idperfil, nome, administrador) FROM stdin;
    public       postgres    false    1667            �          0    27420 
   perfiltela 
   TABLE DATA           F   COPY perfiltela (idperfiltela, idperfil, idtela, idbotao) FROM stdin;
    public       postgres    false    1668            �          0    27423    produto 
   TABLE DATA           �   COPY produto (idproduto, codigo, nome, valor, estoqueminimo, qtdeembalagem, temperaturaentrega, alimentar, idcomposicaocentesimal, unidadeembalagem, unidadeestoque) FROM stdin;
    public       postgres    false    1669            �          0    27429    refeicao 
   TABLE DATA           2   COPY refeicao (idrefeicao, descricao) FROM stdin;
    public       postgres    false    1671            �          0    27432    saldoano 
   TABLE DATA           s   COPY saldoano (idsaldoano, ano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto) FROM stdin;
    public       postgres    false    1672            �          0    27439    saldodia 
   TABLE DATA           �   COPY saldodia (idsaldodia, datasaldodia, saldosaida, saldoentrada, saldocomprometido, saldopendente, idsaldomes, idproduto) FROM stdin;
    public       postgres    false    1673            �          0    27446    saldomes 
   TABLE DATA              COPY saldomes (idsaldomes, mes, idsaldoano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto) FROM stdin;
    public       postgres    false    1674            �          0    36213    situacaocardapio 
   TABLE DATA           B   COPY situacaocardapio (idsituacaocardapio, descricao) FROM stdin;
    public       postgres    false    1736            �          0    36188    situacaoitempedido 
   TABLE DATA           F   COPY situacaoitempedido (idsituacaoitempedido, descricao) FROM stdin;
    public       postgres    false    1734            �          0    27453    situacaoordem 
   TABLE DATA           <   COPY situacaoordem (idsituacaoordem, descricao) FROM stdin;
    public       postgres    false    1675            �          0    27880    situacaopedido 
   TABLE DATA           >   COPY situacaopedido (idsituacaopedido, descricao) FROM stdin;
    public       postgres    false    1723            �          0    27459    tela 
   TABLE DATA           A   COPY tela (idtela, titulotela, nometela, titulomenu) FROM stdin;
    public       postgres    false    1677            �          0    27462 	   telabotao 
   TABLE DATA           :   COPY telabotao (idtelabotao, idtela, idbotao) FROM stdin;
    public       postgres    false    1678            �          0    27465    telefone 
   TABLE DATA           T   COPY telefone (idtelefone, ddd, telefone, idfornecedor, idtipotelefone) FROM stdin;
    public       postgres    false    1679            �          0    27468    tipofornecedor 
   TABLE DATA           >   COPY tipofornecedor (idtipofornecedor, descricao) FROM stdin;
    public       postgres    false    1680            �          0    27471    tipotelefone 
   TABLE DATA           :   COPY tipotelefone (idtipotelefone, descricao) FROM stdin;
    public       postgres    false    1681            �          0    27474    ultimousuario 
   TABLE DATA           :   COPY ultimousuario (usuario, idultimousuario) FROM stdin;
    public       postgres    false    1682            �          0    27477    unidademedida 
   TABLE DATA           U   COPY unidademedida (idunidademedida, nome, miligrama, grama, quilograma) FROM stdin;
    public       postgres    false    1683            �          0    27480    usuario 
   TABLE DATA           S   COPY usuario (idusuario, idcargo, idperfil, nomeusuario, senha, login) FROM stdin;
    public       postgres    false    1684                       2606    27621    Auditoria_pkey 
   CONSTRAINT Z   ALTER TABLE ONLY auditoria
    ADD CONSTRAINT "Auditoria_pkey" PRIMARY KEY (idauditoria);
 D   ALTER TABLE ONLY public.auditoria DROP CONSTRAINT "Auditoria_pkey";
       public         postgres    false    1642    1642                       2606    27623    banco_idbanco_key 
   CONSTRAINT N   ALTER TABLE ONLY banco
    ADD CONSTRAINT banco_idbanco_key UNIQUE (idbanco);
 A   ALTER TABLE ONLY public.banco DROP CONSTRAINT banco_idbanco_key;
       public         postgres    false    1643    1643                       2606    27625 
   botao_pkey 
   CONSTRAINT L   ALTER TABLE ONLY botao
    ADD CONSTRAINT botao_pkey PRIMARY KEY (idbotao);
 :   ALTER TABLE ONLY public.botao DROP CONSTRAINT botao_pkey;
       public         postgres    false    1644    1644                       2606    27627    cardapio_pkey 
   CONSTRAINT U   ALTER TABLE ONLY cardapio
    ADD CONSTRAINT cardapio_pkey PRIMARY KEY (idcardapio);
 @   ALTER TABLE ONLY public.cardapio DROP CONSTRAINT cardapio_pkey;
       public         postgres    false    1646    1646                       2606    27629    cardapioficha_pkey 
   CONSTRAINT o   ALTER TABLE ONLY cardapioficha
    ADD CONSTRAINT cardapioficha_pkey PRIMARY KEY (idcardapio, idfichatecnica);
 J   ALTER TABLE ONLY public.cardapioficha DROP CONSTRAINT cardapioficha_pkey;
       public         postgres    false    1647    1647    1647            {           2606    36249    cardapioordem_pkey 
   CONSTRAINT d   ALTER TABLE ONLY cardapioordem
    ADD CONSTRAINT cardapioordem_pkey PRIMARY KEY (idcardapioordem);
 J   ALTER TABLE ONLY public.cardapioordem DROP CONSTRAINT cardapioordem_pkey;
       public         postgres    false    1740    1740            }           2606    36267    cardapiopedido_pkey 
   CONSTRAINT g   ALTER TABLE ONLY cardapiopedido
    ADD CONSTRAINT cardapiopedido_pkey PRIMARY KEY (idcardapiopedido);
 L   ALTER TABLE ONLY public.cardapiopedido DROP CONSTRAINT cardapiopedido_pkey;
       public         postgres    false    1742    1742            y           2606    36226    cardapiosituacao_pkey 
   CONSTRAINT m   ALTER TABLE ONLY cardapiosituacao
    ADD CONSTRAINT cardapiosituacao_pkey PRIMARY KEY (idcardapiosituacao);
 P   ALTER TABLE ONLY public.cardapiosituacao DROP CONSTRAINT cardapiosituacao_pkey;
       public         postgres    false    1738    1738            !           2606    27631 
   cargo_pkey 
   CONSTRAINT L   ALTER TABLE ONLY cargo
    ADD CONSTRAINT cargo_pkey PRIMARY KEY (idcargo);
 :   ALTER TABLE ONLY public.cargo DROP CONSTRAINT cargo_pkey;
       public         postgres    false    1648    1648            #           2606    27633    composicaocentesimal_pkey 
   CONSTRAINT y   ALTER TABLE ONLY composicaocentesimal
    ADD CONSTRAINT composicaocentesimal_pkey PRIMARY KEY (idcomposicaocentesimal);
 X   ALTER TABLE ONLY public.composicaocentesimal DROP CONSTRAINT composicaocentesimal_pkey;
       public         postgres    false    1649    1649            s           2606    36181    configuracoes_pkey 
   CONSTRAINT d   ALTER TABLE ONLY configuracoes
    ADD CONSTRAINT configuracoes_pkey PRIMARY KEY (idconfiguracoes);
 J   ALTER TABLE ONLY public.configuracoes DROP CONSTRAINT configuracoes_pkey;
       public         postgres    false    1732    1732            %           2606    27635    dadosbancarios_pkey 
   CONSTRAINT g   ALTER TABLE ONLY dadosbancarios
    ADD CONSTRAINT dadosbancarios_pkey PRIMARY KEY (iddadosbancarios);
 L   ALTER TABLE ONLY public.dadosbancarios DROP CONSTRAINT dadosbancarios_pkey;
       public         postgres    false    1650    1650            '           2606    27637 
   email_pkey 
   CONSTRAINT L   ALTER TABLE ONLY email
    ADD CONSTRAINT email_pkey PRIMARY KEY (idemail);
 :   ALTER TABLE ONLY public.email DROP CONSTRAINT email_pkey;
       public         postgres    false    1651    1651            )           2606    27639    fichatecnica_pkey 
   CONSTRAINT a   ALTER TABLE ONLY fichatecnica
    ADD CONSTRAINT fichatecnica_pkey PRIMARY KEY (idfichatecnica);
 H   ALTER TABLE ONLY public.fichatecnica DROP CONSTRAINT fichatecnica_pkey;
       public         postgres    false    1652    1652            +           2606    27641    fichatecnicaitens_pkey 
   CONSTRAINT v   ALTER TABLE ONLY fichatecnicaitens
    ADD CONSTRAINT fichatecnicaitens_pkey PRIMARY KEY (idfichatecnica, idproduto);
 R   ALTER TABLE ONLY public.fichatecnicaitens DROP CONSTRAINT fichatecnicaitens_pkey;
       public         postgres    false    1653    1653    1653            -           2606    27643    formapagamento_pkey 
   CONSTRAINT g   ALTER TABLE ONLY formapagamento
    ADD CONSTRAINT formapagamento_pkey PRIMARY KEY (idformapagamento);
 L   ALTER TABLE ONLY public.formapagamento DROP CONSTRAINT formapagamento_pkey;
       public         postgres    false    1654    1654            /           2606    27645    formapagamentofornecedor_pkey 
   CONSTRAINT �   ALTER TABLE ONLY formapagamentofornecedor
    ADD CONSTRAINT formapagamentofornecedor_pkey PRIMARY KEY (idformapagamentofornecedor);
 `   ALTER TABLE ONLY public.formapagamentofornecedor DROP CONSTRAINT formapagamentofornecedor_pkey;
       public         postgres    false    1655    1655            1           2606    27647    fornecedor_codigo_key 
   CONSTRAINT V   ALTER TABLE ONLY fornecedor
    ADD CONSTRAINT fornecedor_codigo_key UNIQUE (codigo);
 J   ALTER TABLE ONLY public.fornecedor DROP CONSTRAINT fornecedor_codigo_key;
       public         postgres    false    1656    1656            3           2606    27649    fornecedor_pkey 
   CONSTRAINT [   ALTER TABLE ONLY fornecedor
    ADD CONSTRAINT fornecedor_pkey PRIMARY KEY (idfornecedor);
 D   ALTER TABLE ONLY public.fornecedor DROP CONSTRAINT fornecedor_pkey;
       public         postgres    false    1656    1656            5           2606    27651    fornecedorproduto_pkey 
   CONSTRAINT p   ALTER TABLE ONLY fornecedorproduto
    ADD CONSTRAINT fornecedorproduto_pkey PRIMARY KEY (idfornecedorproduto);
 R   ALTER TABLE ONLY public.fornecedorproduto DROP CONSTRAINT fornecedorproduto_pkey;
       public         postgres    false    1657    1657            m           2606    27901    historicopedido_pkey 
   CONSTRAINT j   ALTER TABLE ONLY historicopedido
    ADD CONSTRAINT historicopedido_pkey PRIMARY KEY (idhistoricopedido);
 N   ALTER TABLE ONLY public.historicopedido DROP CONSTRAINT historicopedido_pkey;
       public         postgres    false    1727    1727            q           2606    27950    iditemavaliacao_pkey 
   CONSTRAINT f   ALTER TABLE ONLY itemavaliacao
    ADD CONSTRAINT iditemavaliacao_pkey PRIMARY KEY (iditemavaliacao);
 L   ALTER TABLE ONLY public.itemavaliacao DROP CONSTRAINT iditemavaliacao_pkey;
       public         postgres    false    1731    1731            7           2606    27653    logsistema_pkey 
   CONSTRAINT [   ALTER TABLE ONLY logsistema
    ADD CONSTRAINT logsistema_pkey PRIMARY KEY (idlogsistema);
 D   ALTER TABLE ONLY public.logsistema DROP CONSTRAINT logsistema_pkey;
       public         postgres    false    1659    1659            9           2606    27655    mensagens_pkey 
   CONSTRAINT W   ALTER TABLE ONLY mensagens
    ADD CONSTRAINT mensagens_pkey PRIMARY KEY (idmensagem);
 B   ALTER TABLE ONLY public.mensagens DROP CONSTRAINT mensagens_pkey;
       public         postgres    false    1660    1660            ;           2606    27657    motivo_pkey 
   CONSTRAINT O   ALTER TABLE ONLY motivo
    ADD CONSTRAINT motivo_pkey PRIMARY KEY (idmotivo);
 <   ALTER TABLE ONLY public.motivo DROP CONSTRAINT motivo_pkey;
       public         postgres    false    1661    1661            =           2606    27659    movimento_pkey 
   CONSTRAINT X   ALTER TABLE ONLY movimento
    ADD CONSTRAINT movimento_pkey PRIMARY KEY (idmovimento);
 B   ALTER TABLE ONLY public.movimento DROP CONSTRAINT movimento_pkey;
       public         postgres    false    1662    1662            ?           2606    27661    operacao_pkey 
   CONSTRAINT U   ALTER TABLE ONLY operacao
    ADD CONSTRAINT operacao_pkey PRIMARY KEY (idoperacao);
 @   ALTER TABLE ONLY public.operacao DROP CONSTRAINT operacao_pkey;
       public         postgres    false    1663    1663            A           2606    27663    ordemproducao_pkey 
   CONSTRAINT d   ALTER TABLE ONLY ordemproducao
    ADD CONSTRAINT ordemproducao_pkey PRIMARY KEY (idordemproducao);
 J   ALTER TABLE ONLY public.ordemproducao DROP CONSTRAINT ordemproducao_pkey;
       public         postgres    false    1664    1664            C           2606    27665    ordemproduto_pkey 
   CONSTRAINT a   ALTER TABLE ONLY ordemproduto
    ADD CONSTRAINT ordemproduto_pkey PRIMARY KEY (idordemproduto);
 H   ALTER TABLE ONLY public.ordemproduto DROP CONSTRAINT ordemproduto_pkey;
       public         postgres    false    1665    1665            E           2606    27667    origemordem_pkey 
   CONSTRAINT ^   ALTER TABLE ONLY origemordem
    ADD CONSTRAINT origemordem_pkey PRIMARY KEY (idorigemordem);
 F   ALTER TABLE ONLY public.origemordem DROP CONSTRAINT origemordem_pkey;
       public         postgres    false    1666    1666            k           2606    27893    pedido_pkey 
   CONSTRAINT O   ALTER TABLE ONLY pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (idpedido);
 <   ALTER TABLE ONLY public.pedido DROP CONSTRAINT pedido_pkey;
       public         postgres    false    1725    1725            o           2606    27919    pedidoproduto_pkey 
   CONSTRAINT ^   ALTER TABLE ONLY itempedido
    ADD CONSTRAINT pedidoproduto_pkey PRIMARY KEY (iditempedido);
 G   ALTER TABLE ONLY public.itempedido DROP CONSTRAINT pedidoproduto_pkey;
       public         postgres    false    1729    1729            G           2606    27669    perfil_pkey 
   CONSTRAINT O   ALTER TABLE ONLY perfil
    ADD CONSTRAINT perfil_pkey PRIMARY KEY (idperfil);
 <   ALTER TABLE ONLY public.perfil DROP CONSTRAINT perfil_pkey;
       public         postgres    false    1667    1667            I           2606    27671    perfiltela_pkey 
   CONSTRAINT [   ALTER TABLE ONLY perfiltela
    ADD CONSTRAINT perfiltela_pkey PRIMARY KEY (idperfiltela);
 D   ALTER TABLE ONLY public.perfiltela DROP CONSTRAINT perfiltela_pkey;
       public         postgres    false    1668    1668            K           2606    27673    produto_codigo_key 
   CONSTRAINT P   ALTER TABLE ONLY produto
    ADD CONSTRAINT produto_codigo_key UNIQUE (codigo);
 D   ALTER TABLE ONLY public.produto DROP CONSTRAINT produto_codigo_key;
       public         postgres    false    1669    1669            M           2606    27675    produto_pkey 
   CONSTRAINT R   ALTER TABLE ONLY produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (idproduto);
 >   ALTER TABLE ONLY public.produto DROP CONSTRAINT produto_pkey;
       public         postgres    false    1669    1669            O           2606    27677    refeicao_pkey 
   CONSTRAINT U   ALTER TABLE ONLY refeicao
    ADD CONSTRAINT refeicao_pkey PRIMARY KEY (idrefeicao);
 @   ALTER TABLE ONLY public.refeicao DROP CONSTRAINT refeicao_pkey;
       public         postgres    false    1671    1671            Q           2606    27679    saldoano_pkey 
   CONSTRAINT U   ALTER TABLE ONLY saldoano
    ADD CONSTRAINT saldoano_pkey PRIMARY KEY (idsaldoano);
 @   ALTER TABLE ONLY public.saldoano DROP CONSTRAINT saldoano_pkey;
       public         postgres    false    1672    1672            S           2606    27681    saldodia_pkey 
   CONSTRAINT U   ALTER TABLE ONLY saldodia
    ADD CONSTRAINT saldodia_pkey PRIMARY KEY (idsaldodia);
 @   ALTER TABLE ONLY public.saldodia DROP CONSTRAINT saldodia_pkey;
       public         postgres    false    1673    1673            U           2606    27683    saldomes_pkey 
   CONSTRAINT U   ALTER TABLE ONLY saldomes
    ADD CONSTRAINT saldomes_pkey PRIMARY KEY (idsaldomes);
 @   ALTER TABLE ONLY public.saldomes DROP CONSTRAINT saldomes_pkey;
       public         postgres    false    1674    1674            w           2606    36218    situacaocardapio_pkey 
   CONSTRAINT m   ALTER TABLE ONLY situacaocardapio
    ADD CONSTRAINT situacaocardapio_pkey PRIMARY KEY (idsituacaocardapio);
 P   ALTER TABLE ONLY public.situacaocardapio DROP CONSTRAINT situacaocardapio_pkey;
       public         postgres    false    1736    1736            u           2606    36193    situacaoitempedido_pkey 
   CONSTRAINT s   ALTER TABLE ONLY situacaoitempedido
    ADD CONSTRAINT situacaoitempedido_pkey PRIMARY KEY (idsituacaoitempedido);
 T   ALTER TABLE ONLY public.situacaoitempedido DROP CONSTRAINT situacaoitempedido_pkey;
       public         postgres    false    1734    1734            W           2606    27685    situacaoordem_pkey 
   CONSTRAINT d   ALTER TABLE ONLY situacaoordem
    ADD CONSTRAINT situacaoordem_pkey PRIMARY KEY (idsituacaoordem);
 J   ALTER TABLE ONLY public.situacaoordem DROP CONSTRAINT situacaoordem_pkey;
       public         postgres    false    1675    1675            i           2606    27885    situacaopedido_pkey 
   CONSTRAINT g   ALTER TABLE ONLY situacaopedido
    ADD CONSTRAINT situacaopedido_pkey PRIMARY KEY (idsituacaopedido);
 L   ALTER TABLE ONLY public.situacaopedido DROP CONSTRAINT situacaopedido_pkey;
       public         postgres    false    1723    1723            Y           2606    27687 	   tela_pkey 
   CONSTRAINT I   ALTER TABLE ONLY tela
    ADD CONSTRAINT tela_pkey PRIMARY KEY (idtela);
 8   ALTER TABLE ONLY public.tela DROP CONSTRAINT tela_pkey;
       public         postgres    false    1677    1677            [           2606    27689    telabotao_pkey 
   CONSTRAINT X   ALTER TABLE ONLY telabotao
    ADD CONSTRAINT telabotao_pkey PRIMARY KEY (idtelabotao);
 B   ALTER TABLE ONLY public.telabotao DROP CONSTRAINT telabotao_pkey;
       public         postgres    false    1678    1678            ]           2606    27691    telefone_pkey 
   CONSTRAINT U   ALTER TABLE ONLY telefone
    ADD CONSTRAINT telefone_pkey PRIMARY KEY (idtelefone);
 @   ALTER TABLE ONLY public.telefone DROP CONSTRAINT telefone_pkey;
       public         postgres    false    1679    1679            _           2606    27693    telefone_telefone_key 
   CONSTRAINT V   ALTER TABLE ONLY telefone
    ADD CONSTRAINT telefone_telefone_key UNIQUE (telefone);
 H   ALTER TABLE ONLY public.telefone DROP CONSTRAINT telefone_telefone_key;
       public         postgres    false    1679    1679            a           2606    27695    tipofornecedor_pkey 
   CONSTRAINT g   ALTER TABLE ONLY tipofornecedor
    ADD CONSTRAINT tipofornecedor_pkey PRIMARY KEY (idtipofornecedor);
 L   ALTER TABLE ONLY public.tipofornecedor DROP CONSTRAINT tipofornecedor_pkey;
       public         postgres    false    1680    1680            c           2606    27697    tipotelefone_pkey 
   CONSTRAINT a   ALTER TABLE ONLY tipotelefone
    ADD CONSTRAINT tipotelefone_pkey PRIMARY KEY (idtipotelefone);
 H   ALTER TABLE ONLY public.tipotelefone DROP CONSTRAINT tipotelefone_pkey;
       public         postgres    false    1681    1681            e           2606    27699    unidademedida_pkey 
   CONSTRAINT d   ALTER TABLE ONLY unidademedida
    ADD CONSTRAINT unidademedida_pkey PRIMARY KEY (idunidademedida);
 J   ALTER TABLE ONLY public.unidademedida DROP CONSTRAINT unidademedida_pkey;
       public         postgres    false    1683    1683            g           2606    27701    usuario_pkey 
   CONSTRAINT R   ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (idusuario);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public         postgres    false    1684    1684            �           2620    27702    GravarLog_Banco    TRIGGER �   CREATE TRIGGER "GravarLog_Banco"
    AFTER INSERT OR DELETE OR UPDATE ON banco
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 0   DROP TRIGGER "GravarLog_Banco" ON public.banco;
       public       postgres    false    1643    43            �           2620    27703    GravarLog_Botao    TRIGGER �   CREATE TRIGGER "GravarLog_Botao"
    AFTER INSERT OR DELETE OR UPDATE ON botao
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 0   DROP TRIGGER "GravarLog_Botao" ON public.botao;
       public       postgres    false    43    1644            �           2620    27704    GravarLog_Cargo    TRIGGER �   CREATE TRIGGER "GravarLog_Cargo"
    AFTER INSERT OR DELETE OR UPDATE ON cargo
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 0   DROP TRIGGER "GravarLog_Cargo" ON public.cargo;
       public       postgres    false    1648    43            �           2620    27705    GravarLog_FormaPagamento    TRIGGER �   CREATE TRIGGER "GravarLog_FormaPagamento"
    AFTER INSERT OR DELETE OR UPDATE ON formapagamento
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 B   DROP TRIGGER "GravarLog_FormaPagamento" ON public.formapagamento;
       public       postgres    false    43    1654            �           2620    27706    GravarLog_Motivo    TRIGGER �   CREATE TRIGGER "GravarLog_Motivo"
    AFTER INSERT OR DELETE OR UPDATE ON motivo
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 2   DROP TRIGGER "GravarLog_Motivo" ON public.motivo;
       public       postgres    false    1661    43            �           2620    27707    GravarLog_Perfil    TRIGGER �   CREATE TRIGGER "GravarLog_Perfil"
    AFTER INSERT OR DELETE OR UPDATE ON perfil
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 2   DROP TRIGGER "GravarLog_Perfil" ON public.perfil;
       public       postgres    false    43    1667            �           2620    27708    GravarLog_PerfilTela    TRIGGER �   CREATE TRIGGER "GravarLog_PerfilTela"
    AFTER INSERT OR DELETE OR UPDATE ON perfiltela
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 :   DROP TRIGGER "GravarLog_PerfilTela" ON public.perfiltela;
       public       postgres    false    43    1668            �           2620    27709    GravarLog_Tela    TRIGGER �   CREATE TRIGGER "GravarLog_Tela"
    AFTER INSERT OR DELETE OR UPDATE ON tela
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 .   DROP TRIGGER "GravarLog_Tela" ON public.tela;
       public       postgres    false    1677    43            �           2620    27710    GravarLog_TelaBotao    TRIGGER �   CREATE TRIGGER "GravarLog_TelaBotao"
    AFTER INSERT OR DELETE OR UPDATE ON telabotao
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 8   DROP TRIGGER "GravarLog_TelaBotao" ON public.telabotao;
       public       postgres    false    1678    43            �           2620    27711    GravarLog_UnidadeMedida    TRIGGER �   CREATE TRIGGER "GravarLog_UnidadeMedida"
    AFTER INSERT OR DELETE OR UPDATE ON unidademedida
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 @   DROP TRIGGER "GravarLog_UnidadeMedida" ON public.unidademedida;
       public       postgres    false    43    1683            �           2620    27712    GravarLog_Usuario    TRIGGER �   CREATE TRIGGER "GravarLog_Usuario"
    AFTER INSERT OR DELETE OR UPDATE ON usuario
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 4   DROP TRIGGER "GravarLog_Usuario" ON public.usuario;
       public       postgres    false    1684    43            �           2606    27713    FKidusuario_idcargo    FK CONSTRAINT s   ALTER TABLE ONLY usuario
    ADD CONSTRAINT "FKidusuario_idcargo" FOREIGN KEY (idcargo) REFERENCES cargo(idcargo);
 G   ALTER TABLE ONLY public.usuario DROP CONSTRAINT "FKidusuario_idcargo";
       public       postgres    false    1684    1648    2080            ~           2606    27718    cardapioficha_idcardapio_fkey    FK CONSTRAINT �   ALTER TABLE ONLY cardapioficha
    ADD CONSTRAINT cardapioficha_idcardapio_fkey FOREIGN KEY (idcardapio) REFERENCES cardapio(idcardapio);
 U   ALTER TABLE ONLY public.cardapioficha DROP CONSTRAINT cardapioficha_idcardapio_fkey;
       public       postgres    false    1647    1646    2076                       2606    27723 !   cardapioficha_idfichatecnica_fkey    FK CONSTRAINT �   ALTER TABLE ONLY cardapioficha
    ADD CONSTRAINT cardapioficha_idfichatecnica_fkey FOREIGN KEY (idfichatecnica) REFERENCES fichatecnica(idfichatecnica);
 Y   ALTER TABLE ONLY public.cardapioficha DROP CONSTRAINT cardapioficha_idfichatecnica_fkey;
       public       postgres    false    1647    1652    2088            �           2606    36250    cardapioordem_idcardapio_fkey    FK CONSTRAINT �   ALTER TABLE ONLY cardapioordem
    ADD CONSTRAINT cardapioordem_idcardapio_fkey FOREIGN KEY (idcardapio) REFERENCES cardapio(idcardapio);
 U   ALTER TABLE ONLY public.cardapioordem DROP CONSTRAINT cardapioordem_idcardapio_fkey;
       public       postgres    false    1646    1740    2076            �           2606    36255 "   cardapioordem_idordemproducao_fkey    FK CONSTRAINT �   ALTER TABLE ONLY cardapioordem
    ADD CONSTRAINT cardapioordem_idordemproducao_fkey FOREIGN KEY (idordemproducao) REFERENCES ordemproducao(idordemproducao);
 Z   ALTER TABLE ONLY public.cardapioordem DROP CONSTRAINT cardapioordem_idordemproducao_fkey;
       public       postgres    false    2112    1740    1664            �           2606    36268    cardapiopedido_idcardapio_fkey    FK CONSTRAINT �   ALTER TABLE ONLY cardapiopedido
    ADD CONSTRAINT cardapiopedido_idcardapio_fkey FOREIGN KEY (idcardapio) REFERENCES cardapio(idcardapio);
 W   ALTER TABLE ONLY public.cardapiopedido DROP CONSTRAINT cardapiopedido_idcardapio_fkey;
       public       postgres    false    1646    1742    2076            �           2606    36273    cardapiopedido_idpedido_fkey    FK CONSTRAINT �   ALTER TABLE ONLY cardapiopedido
    ADD CONSTRAINT cardapiopedido_idpedido_fkey FOREIGN KEY (idpedido) REFERENCES pedido(idpedido);
 U   ALTER TABLE ONLY public.cardapiopedido DROP CONSTRAINT cardapiopedido_idpedido_fkey;
       public       postgres    false    2154    1742    1725            �           2606    36237     cardapiosituacao_idcardapio_fkey    FK CONSTRAINT �   ALTER TABLE ONLY cardapiosituacao
    ADD CONSTRAINT cardapiosituacao_idcardapio_fkey FOREIGN KEY (idcardapio) REFERENCES cardapio(idcardapio);
 [   ALTER TABLE ONLY public.cardapiosituacao DROP CONSTRAINT cardapiosituacao_idcardapio_fkey;
       public       postgres    false    2076    1738    1646            �           2606    36232 (   cardapiosituacao_idsituacaocardapio_fkey    FK CONSTRAINT �   ALTER TABLE ONLY cardapiosituacao
    ADD CONSTRAINT cardapiosituacao_idsituacaocardapio_fkey FOREIGN KEY (idsituacaocardapio) REFERENCES situacaocardapio(idsituacaocardapio);
 c   ALTER TABLE ONLY public.cardapiosituacao DROP CONSTRAINT cardapiosituacao_idsituacaocardapio_fkey;
       public       postgres    false    1736    1738    2166            �           2606    27728    dadosbancarios_idbanco_fkey    FK CONSTRAINT �   ALTER TABLE ONLY dadosbancarios
    ADD CONSTRAINT dadosbancarios_idbanco_fkey FOREIGN KEY (idbanco) REFERENCES banco(idbanco);
 T   ALTER TABLE ONLY public.dadosbancarios DROP CONSTRAINT dadosbancarios_idbanco_fkey;
       public       postgres    false    1650    1643    2072            �           2606    27733    email_idfornecedor_fkey    FK CONSTRAINT �   ALTER TABLE ONLY email
    ADD CONSTRAINT email_idfornecedor_fkey FOREIGN KEY (idfornecedor) REFERENCES fornecedor(idfornecedor);
 G   ALTER TABLE ONLY public.email DROP CONSTRAINT email_idfornecedor_fkey;
       public       postgres    false    1651    1656    2098            �           2606    27738 .   formapagamentofornecedor_idformapagamento_fkey    FK CONSTRAINT �   ALTER TABLE ONLY formapagamentofornecedor
    ADD CONSTRAINT formapagamentofornecedor_idformapagamento_fkey FOREIGN KEY (idformapagamento) REFERENCES formapagamento(idformapagamento);
 q   ALTER TABLE ONLY public.formapagamentofornecedor DROP CONSTRAINT formapagamentofornecedor_idformapagamento_fkey;
       public       postgres    false    1655    1654    2092            �           2606    27743 *   formapagamentofornecedor_idfornecedor_fkey    FK CONSTRAINT �   ALTER TABLE ONLY formapagamentofornecedor
    ADD CONSTRAINT formapagamentofornecedor_idfornecedor_fkey FOREIGN KEY (idfornecedor) REFERENCES fornecedor(idfornecedor);
 m   ALTER TABLE ONLY public.formapagamentofornecedor DROP CONSTRAINT formapagamentofornecedor_idfornecedor_fkey;
       public       postgres    false    1656    1655    2098            �           2606    27748     fornecedor_iddadosbancarios_fkey    FK CONSTRAINT �   ALTER TABLE ONLY fornecedor
    ADD CONSTRAINT fornecedor_iddadosbancarios_fkey FOREIGN KEY (iddadosbancarios) REFERENCES dadosbancarios(iddadosbancarios);
 U   ALTER TABLE ONLY public.fornecedor DROP CONSTRAINT fornecedor_iddadosbancarios_fkey;
       public       postgres    false    1650    1656    2084            �           2606    27753 #   fornecedorproduto_idfornecedor_fkey    FK CONSTRAINT �   ALTER TABLE ONLY fornecedorproduto
    ADD CONSTRAINT fornecedorproduto_idfornecedor_fkey FOREIGN KEY (idfornecedor) REFERENCES fornecedor(idfornecedor);
 _   ALTER TABLE ONLY public.fornecedorproduto DROP CONSTRAINT fornecedorproduto_idfornecedor_fkey;
       public       postgres    false    1657    1656    2098            �           2606    27758     fornecedorproduto_idproduto_fkey    FK CONSTRAINT �   ALTER TABLE ONLY fornecedorproduto
    ADD CONSTRAINT fornecedorproduto_idproduto_fkey FOREIGN KEY (idproduto) REFERENCES produto(idproduto);
 \   ALTER TABLE ONLY public.fornecedorproduto DROP CONSTRAINT fornecedorproduto_idproduto_fkey;
       public       postgres    false    1657    1669    2124            �           2606    27763 '   fornecedorproduto_idtipofornecedor_fkey    FK CONSTRAINT �   ALTER TABLE ONLY fornecedorproduto
    ADD CONSTRAINT fornecedorproduto_idtipofornecedor_fkey FOREIGN KEY (idtipofornecedor) REFERENCES tipofornecedor(idtipofornecedor);
 c   ALTER TABLE ONLY public.fornecedorproduto DROP CONSTRAINT fornecedorproduto_idtipofornecedor_fkey;
       public       postgres    false    1657    1680    2144            �           2606    27902    historicopedido_idpedido_fkey    FK CONSTRAINT �   ALTER TABLE ONLY historicopedido
    ADD CONSTRAINT historicopedido_idpedido_fkey FOREIGN KEY (idpedido) REFERENCES pedido(idpedido);
 W   ALTER TABLE ONLY public.historicopedido DROP CONSTRAINT historicopedido_idpedido_fkey;
       public       postgres    false    1727    2154    1725            �           2606    27907 %   historicopedido_idsituacaopedido_fkey    FK CONSTRAINT �   ALTER TABLE ONLY historicopedido
    ADD CONSTRAINT historicopedido_idsituacaopedido_fkey FOREIGN KEY (idsituacaopedido) REFERENCES situacaopedido(idsituacaopedido);
 _   ALTER TABLE ONLY public.historicopedido DROP CONSTRAINT historicopedido_idsituacaopedido_fkey;
       public       postgres    false    2152    1727    1723            �           2606    27951 !   iditemavaliacao_iditempedido_fkey    FK CONSTRAINT �   ALTER TABLE ONLY itemavaliacao
    ADD CONSTRAINT iditemavaliacao_iditempedido_fkey FOREIGN KEY (iditempedido) REFERENCES itempedido(iditempedido);
 Y   ALTER TABLE ONLY public.itemavaliacao DROP CONSTRAINT iditemavaliacao_iditempedido_fkey;
       public       postgres    false    1729    2158    1731            �           2606    27956    iditemavaliacao_idmotivo_fkey    FK CONSTRAINT �   ALTER TABLE ONLY itemavaliacao
    ADD CONSTRAINT iditemavaliacao_idmotivo_fkey FOREIGN KEY (idmotivo) REFERENCES motivo(idmotivo);
 U   ALTER TABLE ONLY public.itemavaliacao DROP CONSTRAINT iditemavaliacao_idmotivo_fkey;
       public       postgres    false    1661    2106    1731            �           2606    36194 '   itemavaliacao_idsituacaoitempedido_fkey    FK CONSTRAINT �   ALTER TABLE ONLY itemavaliacao
    ADD CONSTRAINT itemavaliacao_idsituacaoitempedido_fkey FOREIGN KEY (idsituacaoitempedido) REFERENCES situacaoitempedido(idsituacaoitempedido);
 _   ALTER TABLE ONLY public.itemavaliacao DROP CONSTRAINT itemavaliacao_idsituacaoitempedido_fkey;
       public       postgres    false    1731    1734    2164            �           2606    27768    movimento_idoperacao_fkey    FK CONSTRAINT �   ALTER TABLE ONLY movimento
    ADD CONSTRAINT movimento_idoperacao_fkey FOREIGN KEY (idoperacao) REFERENCES operacao(idoperacao);
 M   ALTER TABLE ONLY public.movimento DROP CONSTRAINT movimento_idoperacao_fkey;
       public       postgres    false    1662    1663    2110            �           2606    27773    movimento_idproduto_fkey    FK CONSTRAINT ~   ALTER TABLE ONLY movimento
    ADD CONSTRAINT movimento_idproduto_fkey FOREIGN KEY (idproduto) REFERENCES produto(idproduto);
 L   ALTER TABLE ONLY public.movimento DROP CONSTRAINT movimento_idproduto_fkey;
       public       postgres    false    1669    1662    2124            �           2606    27778    movimento_idunidademedida_fkey    FK CONSTRAINT �   ALTER TABLE ONLY movimento
    ADD CONSTRAINT movimento_idunidademedida_fkey FOREIGN KEY (idunidademedida) REFERENCES unidademedida(idunidademedida);
 R   ALTER TABLE ONLY public.movimento DROP CONSTRAINT movimento_idunidademedida_fkey;
       public       postgres    false    1683    1662    2148            �           2606    27783     ordemproducao_idorigemordem_fkey    FK CONSTRAINT �   ALTER TABLE ONLY ordemproducao
    ADD CONSTRAINT ordemproducao_idorigemordem_fkey FOREIGN KEY (idorigemordem) REFERENCES origemordem(idorigemordem);
 X   ALTER TABLE ONLY public.ordemproducao DROP CONSTRAINT ordemproducao_idorigemordem_fkey;
       public       postgres    false    1664    1666    2116            �           2606    27788    ordemproducao_idrefeicao_fkey    FK CONSTRAINT �   ALTER TABLE ONLY ordemproducao
    ADD CONSTRAINT ordemproducao_idrefeicao_fkey FOREIGN KEY (idrefeicao) REFERENCES refeicao(idrefeicao);
 U   ALTER TABLE ONLY public.ordemproducao DROP CONSTRAINT ordemproducao_idrefeicao_fkey;
       public       postgres    false    1671    1664    2126            �           2606    27793 "   ordemproducao_idsituacaoordem_fkey    FK CONSTRAINT �   ALTER TABLE ONLY ordemproducao
    ADD CONSTRAINT ordemproducao_idsituacaoordem_fkey FOREIGN KEY (idsituacaoordem) REFERENCES situacaoordem(idsituacaoordem);
 Z   ALTER TABLE ONLY public.ordemproducao DROP CONSTRAINT ordemproducao_idsituacaoordem_fkey;
       public       postgres    false    1664    1675    2134            �           2606    27798 !   ordemproduto_idordemproducao_fkey    FK CONSTRAINT �   ALTER TABLE ONLY ordemproduto
    ADD CONSTRAINT ordemproduto_idordemproducao_fkey FOREIGN KEY (idordemproducao) REFERENCES ordemproducao(idordemproducao);
 X   ALTER TABLE ONLY public.ordemproduto DROP CONSTRAINT ordemproduto_idordemproducao_fkey;
       public       postgres    false    1665    2112    1664            �           2606    27803    ordemproduto_idproduto_fkey    FK CONSTRAINT �   ALTER TABLE ONLY ordemproduto
    ADD CONSTRAINT ordemproduto_idproduto_fkey FOREIGN KEY (idproduto) REFERENCES produto(idproduto);
 R   ALTER TABLE ONLY public.ordemproduto DROP CONSTRAINT ordemproduto_idproduto_fkey;
       public       postgres    false    1669    2124    1665            �           2606    27808 !   ordemproduto_idunidademedida_fkey    FK CONSTRAINT �   ALTER TABLE ONLY ordemproduto
    ADD CONSTRAINT ordemproduto_idunidademedida_fkey FOREIGN KEY (idunidademedida) REFERENCES unidademedida(idunidademedida);
 X   ALTER TABLE ONLY public.ordemproduto DROP CONSTRAINT ordemproduto_idunidademedida_fkey;
       public       postgres    false    1665    1683    2148            �           2606    27920    pedidoproduto_idpedido_fkey    FK CONSTRAINT    ALTER TABLE ONLY itempedido
    ADD CONSTRAINT pedidoproduto_idpedido_fkey FOREIGN KEY (idpedido) REFERENCES pedido(idpedido);
 P   ALTER TABLE ONLY public.itempedido DROP CONSTRAINT pedidoproduto_idpedido_fkey;
       public       postgres    false    2154    1725    1729            �           2606    27925    pedidoproduto_idproduto_fkey    FK CONSTRAINT �   ALTER TABLE ONLY itempedido
    ADD CONSTRAINT pedidoproduto_idproduto_fkey FOREIGN KEY (idproduto) REFERENCES produto(idproduto);
 Q   ALTER TABLE ONLY public.itempedido DROP CONSTRAINT pedidoproduto_idproduto_fkey;
       public       postgres    false    1669    1729    2124            �           2606    27930 "   pedidoproduto_idunidademedida_fkey    FK CONSTRAINT �   ALTER TABLE ONLY itempedido
    ADD CONSTRAINT pedidoproduto_idunidademedida_fkey FOREIGN KEY (idunidademedida) REFERENCES unidademedida(idunidademedida);
 W   ALTER TABLE ONLY public.itempedido DROP CONSTRAINT pedidoproduto_idunidademedida_fkey;
       public       postgres    false    2148    1683    1729            �           2606    27813    perfiltela_idbotao_fkey    FK CONSTRAINT x   ALTER TABLE ONLY perfiltela
    ADD CONSTRAINT perfiltela_idbotao_fkey FOREIGN KEY (idbotao) REFERENCES botao(idbotao);
 L   ALTER TABLE ONLY public.perfiltela DROP CONSTRAINT perfiltela_idbotao_fkey;
       public       postgres    false    2074    1668    1644            �           2606    27818    perfiltela_idperfil_fkey    FK CONSTRAINT |   ALTER TABLE ONLY perfiltela
    ADD CONSTRAINT perfiltela_idperfil_fkey FOREIGN KEY (idperfil) REFERENCES perfil(idperfil);
 M   ALTER TABLE ONLY public.perfiltela DROP CONSTRAINT perfiltela_idperfil_fkey;
       public       postgres    false    1667    1668    2118            �           2606    27823    perfiltela_idtela_fkey    FK CONSTRAINT t   ALTER TABLE ONLY perfiltela
    ADD CONSTRAINT perfiltela_idtela_fkey FOREIGN KEY (idtela) REFERENCES tela(idtela);
 K   ALTER TABLE ONLY public.perfiltela DROP CONSTRAINT perfiltela_idtela_fkey;
       public       postgres    false    1677    1668    2136            �           2606    27828 #   produto_idcomposicaocentesimal_fkey    FK CONSTRAINT �   ALTER TABLE ONLY produto
    ADD CONSTRAINT produto_idcomposicaocentesimal_fkey FOREIGN KEY (idcomposicaocentesimal) REFERENCES composicaocentesimal(idcomposicaocentesimal);
 U   ALTER TABLE ONLY public.produto DROP CONSTRAINT produto_idcomposicaocentesimal_fkey;
       public       postgres    false    1649    1669    2082            �           2606    27833    saldoano_idproduto_fkey    FK CONSTRAINT |   ALTER TABLE ONLY saldoano
    ADD CONSTRAINT saldoano_idproduto_fkey FOREIGN KEY (idproduto) REFERENCES produto(idproduto);
 J   ALTER TABLE ONLY public.saldoano DROP CONSTRAINT saldoano_idproduto_fkey;
       public       postgres    false    1669    1672    2124            �           2606    27838    saldodia_idproduto_fkey    FK CONSTRAINT |   ALTER TABLE ONLY saldodia
    ADD CONSTRAINT saldodia_idproduto_fkey FOREIGN KEY (idproduto) REFERENCES produto(idproduto);
 J   ALTER TABLE ONLY public.saldodia DROP CONSTRAINT saldodia_idproduto_fkey;
       public       postgres    false    1669    1673    2124            �           2606    27843    saldodia_idsaldomes_fkey    FK CONSTRAINT �   ALTER TABLE ONLY saldodia
    ADD CONSTRAINT saldodia_idsaldomes_fkey FOREIGN KEY (idsaldomes) REFERENCES saldomes(idsaldomes);
 K   ALTER TABLE ONLY public.saldodia DROP CONSTRAINT saldodia_idsaldomes_fkey;
       public       postgres    false    1674    1673    2132            �           2606    27848    saldomes_idproduto_fkey    FK CONSTRAINT |   ALTER TABLE ONLY saldomes
    ADD CONSTRAINT saldomes_idproduto_fkey FOREIGN KEY (idproduto) REFERENCES produto(idproduto);
 J   ALTER TABLE ONLY public.saldomes DROP CONSTRAINT saldomes_idproduto_fkey;
       public       postgres    false    1669    1674    2124            �           2606    27853    saldomes_idsaldoano_fkey    FK CONSTRAINT �   ALTER TABLE ONLY saldomes
    ADD CONSTRAINT saldomes_idsaldoano_fkey FOREIGN KEY (idsaldoano) REFERENCES saldoano(idsaldoano);
 K   ALTER TABLE ONLY public.saldomes DROP CONSTRAINT saldomes_idsaldoano_fkey;
       public       postgres    false    1672    1674    2128            �           2606    27858    telabotao_idbotao_fkey    FK CONSTRAINT v   ALTER TABLE ONLY telabotao
    ADD CONSTRAINT telabotao_idbotao_fkey FOREIGN KEY (idbotao) REFERENCES botao(idbotao);
 J   ALTER TABLE ONLY public.telabotao DROP CONSTRAINT telabotao_idbotao_fkey;
       public       postgres    false    1644    1678    2074            �           2606    27863    telabotao_idtela_fkey    FK CONSTRAINT r   ALTER TABLE ONLY telabotao
    ADD CONSTRAINT telabotao_idtela_fkey FOREIGN KEY (idtela) REFERENCES tela(idtela);
 I   ALTER TABLE ONLY public.telabotao DROP CONSTRAINT telabotao_idtela_fkey;
       public       postgres    false    1678    1677    2136            �           2606    27868    telefone_idfornecedor_fkey    FK CONSTRAINT �   ALTER TABLE ONLY telefone
    ADD CONSTRAINT telefone_idfornecedor_fkey FOREIGN KEY (idfornecedor) REFERENCES fornecedor(idfornecedor);
 M   ALTER TABLE ONLY public.telefone DROP CONSTRAINT telefone_idfornecedor_fkey;
       public       postgres    false    2098    1679    1656            �           2606    27873    telefone_idtipotelefone_fkey    FK CONSTRAINT �   ALTER TABLE ONLY telefone
    ADD CONSTRAINT telefone_idtipotelefone_fkey FOREIGN KEY (idtipotelefone) REFERENCES tipotelefone(idtipotelefone);
 O   ALTER TABLE ONLY public.telefone DROP CONSTRAINT telefone_idtipotelefone_fkey;
       public       postgres    false    1681    1679    2146            �     x����r�6���S�j�Ah�%�tZ���q�K.��L)�%iO'����w� %~� m�C۲��o���/B����Z���Lb��3ee�ߣ�D��)�6׋/��䤍/k/��w�N�JS��󓘞%�4�����{�[]�;ۀ�E}���N!ޢxIL�-ҭΣ�N+�֚�N���6jL�:[��j0��s�QP�k�`<+������n(_=%i��� O��4$٧���
��E���;}��u"ؿ�-\<��5���˕��W��*��v�f&�u2��ef2�'C���Hۀ0�d�O�F�)��ɴ�\��W|@�ZT��.Mi�y�lN��dCi���b��Ҡ���%aP��%�|�o�[��ʡ@�E��p������n��cS�`��VM����I�5@Ș���ɌHK��P����!#x6ri�X $T� �6� �c�31�=n1fP��g�s��9o1�"����yVH<�01�:C[� ��k�ݚ�ೡ=�a!��y�R9�h��P@�l��K"��<^b
	����:VF�b��1� Hլ3A���|���m&�ѻt��U���qL@F�����0�w8�p�^A�Ĭw7�)��\����<����*�`&!�٬����߼�	� �m7�bv����Q����hr	q,g�f�� F�3����9k߄DF}�Xr2�Z�g���1��2�}�1�w�_�t[��F������!��#�&��E�cC��k�]�`��/)�H�[�b㆞zޏ=CK�!%�N�)_dS�߉8�El�� u"���ئ����_d��:`��E6-Co����"�:��u���{"N�1H�8�|ol���2�5f�,.|
uc���h�=�����vu��G� ��vx�	����az�fPb�ޛ&��K3�%��V�L���~��U]��~��l!���c�i��N77��F���Meœ=��*}��A��B��%w�_���yR�Jl�;���K�8��(7ׅ�x㥍�ޕM$1��i*���(0q�Wi�����O�4щٛ��\XX����C(�_	�R�;t��y���Fs��t���ϋ�V1��ʪ��.�- �lgB9��O���GS T � d
���e@�1���P�9Ar[_�$	$�I��jRL�̯i��i1�]�%"B�!��q��18o�yyq��b�f>70�~�ɫ�B���uV�}6�m�L֡u��6l�����3��ot���>�'7��#�1E��l0�<z,��ʛ��7{��h-
|� ���^o�      �   =   x�KL)NKL+N�44�J,NIK,NK�45�rvqaN#.��!����5����� �>h      �   �   x�]�K
�0���)���؅Wn��(�4��Qz_^ä���|3���d#�ht�U�BG��i�FO��C�=���Z�#��f��ؘ��3�
�]��O�čM�e�P`g�A�!��,���Q{�{1�-M��1'"te
�S�mx�\��e;�8��W��a-�I��>���JJ�b'h�      �      x�34�420��54�52�4�4����� .�      �      x�34������ �W      �      x������ � �      �      x�3�44�41����� t�      �   ,   x���44�4�420��54�54S0��22�22�37������� q�      �   �   x�m��N�0E뙯�,�yP�iA@I3�����l��_P��A�i�]�AA[�5���nأ���Ʃ�c���Q/��鱅�T��sa�Y�S�	��:X����M۝Vm��E:k�''���ufˁ�(�B:��L�?T4����$�S�F&1蚅Xt-\�GyRga;̦���9��H�����������`]�>.��D��r]Z      �   P   x����	�@B��0AC:E'���(\�w-� �@�i�Ze"���k*�VǴ*W@�.�PH;���,��g#������C�1�      �   �   x����
1D뻯�R��V�	~���r7���l��w-����:000�7��_Y����E�8\K��n��oӮ;�RA�X�jb�#��+S��
����m����RH1�qt�(C[�e�e�G�8��ˀ���I�M�曪:'�����e�����4AGKsf�o�M}߿�?\"      �   G   x�]���@�P�9K,�������E&PJP⹸"�������ז�����r��2L������      �   W   x�3�LK,NIKq(�z v1�9�1g"���r-8���K2��J�r�J2�R��s3s���s9-�,9�RR�rJ3�$b���� �b �      �   F   x���tK���OLI�tί���H,R�WH�=��4�3�44�300�42S&�!>�BC)=CS�=... ��      �      x���4��445�300��R&\1z\\\ =~$      �   `   x�3�L,NI�,�2�,NLIK,�M��0̙�e
 ɥ@pJZ1L�)%��:�Pt�$��朆F��(f��Z�8�$_!)1/�aQf>О=... ��.      �      x������ � �      �   �  x�m��r�0�g�)��a@���^;t�ҎY� m���^_�C^��E�	$c��l�"�'>Xh��:Tk"��>���ƕ8s���Alb��,J�nF�����7���X��S6�5w�A��q�I���A���0s����=�����/�@U����>.��ÙߦR�B��qNŞv�y�ft�ө9��0���4�(�!Y��T�y^��������w\ ��0b�U]�Յ�.+.U	Ia`�T~y����ph"(.�jyj��f���1��H���,���E�a)B�4B&�<%� @Z��ҴG:�-@�g86o���Q%�����_}S�:R����wIā��FÕ*��fM�����r���n�L-�v�=N�����F���1�
d��      �   M   x�-��	 !��d�Ҵ
���?�U=�>ҁ�� ���}W��-�r��0��S�]{d���9��w9��� V�      �   =   x�31�41�4�420��54�54S0��22�26�3�4�J�����������W� �O�      �   4   x�35�43��4�L�420��54�54S0��26�24�310�50����� ��      �      x�33�41�4��47�300�4����� ,m      �      x�u�=�.��\k�ۊӁ3�$�l_-�+�Fȑ#C��� ��*d�{[��Y�E�I l�������U�?��#��[�w�?���������)��?��Z��?��,�&������e�2��݂O�,�������+]��b�*��2W�*�?:����T���?��J�zf���.�7�,�59ʟ��&��?d����#�?X�y=?�lx7�����-�-Sv���>�JX8�)����`H����?���`��G�O����L��ɿ�h�گl�~yTǄ�G�U2�#<���"�'�?��5{b�wސ�+����}T��AB?�!�+�?c���Ol�����ʟW�?�ʾ~��G�6H���~�*<r�?~��U��ʣj+���>r�r������ۼB�TP��ǜ��g|�I�tMZ��[���������?�t\���?���4Y���?��Ȩ����3�������.{Cewx�b�>S��{@�I��c����>S������������L(g&�O�7V.SJ�?�(�>�"?s�3;+�BR�B�Y�#��L���#��h;c�eG>������@ޑ��Ӫ��QG@G�le��EB�+�7���늈lM>�����qT��l�;�L�H&t梳N���G�e@6�ǰ2���^�06�	��L���@�2�3��Y�pjU�s����)樔�����g"��x�f����ʏj:�	Ŵ��5�?j!��!��64���IY�g^�K��6����,�gR�9S�(*0���nkŗ�X�F��,6���,�<E���JԶ��E�dB瓬'^����&:��o��':�i�?���d<GwF���1�Yw-����0��<����>�	x��v���(К��'�(G9>��Q��	��(8���i��7d=��H'է��OV����y�G�:�w�KI�}9m�'�52ݙ_��5Yi��O�I������%Q�b8g>���7��Ή7�B1��ҏj3��o�56�Ȥ����6�9+�y��=�F<����yd�����(f��|<��C<����F<.<��ol���Z�����x��]���!��!���n����d�f����-���u�m�ɊdҳN�F�tVʤ�Q��'4���edҳ����23��wK�}�"��?c�RT�q7ÿT�9���0έ�1���VjeTB�8���Q��6�o���&�����eYLN�g��J�_U����`�N7��N�� ���v����INH�Ly�8��Yz�����²ea�,��e�f����j@�n5,��}S5a��rHۗ����Y��7YCP.��Sɾj�f[��
O=����ܦ�6���Jl�{V�R�����r���� ,y��lw	�:��7
|-�#�u�'��	@���%���	�T°��U�P�u�U9��"jp��k!Ŧ-Q���({��?�.� |=V���W=�m?������8�'�/�U��4��j|���_����V��j��5�R�+0B��lpi-�2S$U�ݠ�rY8���o�g�l��Õ��R�1�ˢ��JOx���6I���k��1л$��i�����)
P�%��N�2�3\-�g#�a�;.���ʰ,��ժ2�.f��hQ�e��$��2��a��ʰ��v>X��u �j~�-\dU�8#`Q6�}V����@X�֬�W�4<V����-�x��ª>a��@h ,��5+��.���T_���T��R��38�O=����}�e�ۤ�)	�:�M�����2���P��&N�j�`/<&��jK�\6qvwi�d�W���ʻh�O=��k����B�+��t���{��L\��O���`M<�f:�`N��,[^x!��#]��+EXÖ��j�o]Hk��|��p~ᲅ�Ƴo��q!����n��R�5���>�+EZ��뙈c<j�����8��W�5����8�C�j#�i[���5k#��[q�m�5��`&��aM�;N�l#,��LF�FX���%Y�6��_��m�5mC\��e#,���zdaM���l�V��o����´���ZaZ�#�-I+L�#}�g�´�#����u�g�E�d�0����4�´��c��h���uv�'n��s+L�C�Ѡ��ʴ��(��[eZv��^S�+eZ'r����KeZv�:9�h�i��|7��?�1�#��.l�LK�E��ķʴ�ٟS��U�����b�*�:R��k�O�ZcZjNg2�R�9�1�<#�i�9��D&uv��b�a�֘�Ώ+�}*��e �KL�ZB��*'Z4$�,�,�ahA-߼�dj��K;���	�Z�ĉ+��֓��f������>� s�~3Hާ��*��TR�߀��~��M�:��L���H����:�ƅ�uv;�O�A��=w��N�u���z2�u��r�Jb�t���B�+X��jY���5�����B��~�����JW�Y���f��yI&EV��.M~�"�������Zp�{H��t|ӂ+�H��{'���
<RK��-a��_鎾��Zp��s&�u���3c�ס\�G�H�E(��J��T�j�x�npL�G�QcG�F��s�(�m#a���z��zX����\x̪{vy-m0����aY̪{&�D�f���������dXGz� �ɴN�t>�Dʴ,fJ<�6�����m2�3c���|{b�L�Hm����m2-˷i0Y�L�ցŻ�6��'g��:� ����%ُ,�U=Ie%��BZ���7I�����-���3���V5_�H<�6Y[˥�wd���\z~�|��M�ª�1DɱYU��ۊ�I&k�YY��f[�-fe3V�����fVv�^�k�QٱG�y&k�Y�J���턕-�!i�Tm3��������ͨ����k�fT]��dm3+uo6��oYY�䃕&������l���d��ލIAX��#��L
º�@Y�2�j��T�� �f�K)15�dRV{w��� ��\�C�������\z������={�N��0,K�q�eO�ʰ�7���'JeX7s��ԥ2��b�����R��zS��r�cX���r�m���֤G*ò�늱�ɤ2,�<3:x�ʰ�Υ�4�Lj��<��1��d��Km$Xa�?�qŸ�d��K{�%%iyB����O�!��{5��������C����L�3,I�iH릐�x�d2iH˥]��S�i�ڜ�;i2���]e� �n)H}�{=2�������&����B��+82�eɨ��7+����+�-����"-�B&AX.�ʡ���f�跚L:��~�Ւ�3,Kȝ�p}�zd���khR3������d��=*�#U�K<�(̮G%�YY06��I:���IS��	�x�h2�˲Y+���Ϗ��<UMʰ�����UV�D�G&�`�T�d!�U?K_)�R�	�Ʉ�ܚ�L��`�?�b&�Ʉ}��x�&�J|G&da���Y�B�K��*bM&�a��
oh�$C=il�4D�z�����0lŲ�NՅ,}�q2G�,�U��r0l��U;���L��p���|A��d��8�iRd5�O�`�le�0��B�x��Ʉ�{�^�D20�r��e�	�lo3ȿ4��4h*!��*��ϞKL7��}1�cj~*��S`J0�M%d_\�dSFȾv���8�}�!���%��	g�	�&u�?x&�/�>�j<�п0����t���euL/����	��߀�R��aIۖ�P�n2A�3=��'640L�l���	WjŜ8���q���ƟzBA40�bx,J���n�����}q���>@t/n!F��Q�	�O���}KG��@��#�ut/��D,�6�ѽ0�'�~�~Sut/��|+��tt/��
���L�ѽ��g�#ڎ�Im��5Su4/n���C� �G��f��4Dz����,����z�.�i�Q���}�b؋��G��Z= �M��]�	��1L֣y񛋜آ=�o.���'?`�tz=̷��d=����d�;�2�f�?�zeZ^>���ޘ�M�(�7�%�fr�NoLˌY�,�ޘ֝i�6�u�{˰F�7�u�I(��a��,<�:q��	PFM    o�D�}�}��zXu�+'�Z`���;~��,1i%�m��X�����dJoߧ�iP$��i�������!c��g͔"'Ĳ~,�������e�̤6�!ңw1��e;�o j���aO�>��B�.��3Um��uq�V^ʵ=ZW�I����Ѻp��5���G��W��/;Z����M��%z���1z�.�S�k�r����Ro�3fGX��.x%T�uk�~���R�՞sWrں"-��e�#�uEZ�{r,�H�Rz���{�o��H�;fX���xW�e�q��LW�%��9�iꊴnY�H-EZJ�!��%6�����@Z^Fw�ntJ�Һ])J��R�L>�������u2YL����h^̧�꼁�ݑ��G�╪&Aft/����㛬G��Z�:�Yѽ�Ok�9&�ѽx���m�ѽ�o����d=��T��݋Wj��7S�d=��i�Q���>�Vm�ʠ����dZv�����iY�;����O�e��#�]Ӳ�������eR�u���|�������d}%�<������VsZ�+[L�W�d�ZL�K���}T}1,��sU�bX�Ͷ��<����-����Ko���q7Y�5�JK~�n$�[�b�#�X��%<I�fߝ��c	�3&�[Ij�I���G&�%���k��'K�,����X*��лBX͛���k2-�JG<(�[²�k6aQ�����0Ok�e2-K���UZ���/�\L��YI���>�YI��z�iaV���fA-̪��{X(eXg�?/ 83&�ʰ�c,�]�2,Uj�`2�Ko5-Z#Z��NhL�4�V�e�dgB+�R��Y@+���qVxKm�*��L��iEZ�)�J�fL�i�M�]8 Ն�<v��,�iCZ.��M��҆�lj��y��iCZb�6:�ڐ��!��dT5$�첌mLʚ[%uژ���AǞژ��9DyEژ���g(�1�
�R?���}e��&CU�}ד7�*�*]z�Z����F	J6�Fc=v��2�i40��"N^05��*cu��SW�i40\*�����d�+��&�h`�'˿p:�Fc=&�%7~�v�i40�c���F��U���}�5GR��m��[��"���}ORM�}��ORi���J�>�ői_�T�s훥�ύG�&S-��v-����~*�iˤ'	Y�&S�6�J�|UdUݑ���&SeVn�ӣʬ��k��L�a�*��oVeVV��C���T����s�`Tݿ?���귟M:���|	5&���ԫ]i3��YYf%8�&����Έ2u *y��Q�Duݫ�K�d����P4��G�Ԝ�DX�L�L9�",��t'K�DX�X����z",_�$���ċ�V�W!+�d�w�&Ӊ�\*�O<t",�Q�&Z7:��`��c&Ӊ�\jE.h3�BXޢ��V�+EX�K�m���J�5ԅ�����&Ӆ�n�� �4R0�.5��'�+��A����&�Š��9_J<	:��L7�o͟�fP�l���nu��R��n&%��Z�/�t3(����n�%�9y�z`�V���a���D�؏L�i�]Z?)�ߧn�z�ȸ;�\��ޣpA�TFp-���չ���J�YM6�k��[:�ލ�Z��օ.1G�d#���l
��x�볲�O�������)-��p0�i������FEVV2���߹"*�J��Q��'i���nh%�X��ʫ�j���FET���,yTD�U~���Q���<V+���M"awk�Q������h�J�qv82�h˲ӎ}�!��/�R����2zL6�r�״����w��i����b4���\�l4���4S��hH�j'�����1�����q��uMV��aX��
�!�2�¬,�����dC��M�5W¬���S�Ɇ0+u��"�!�J��4��Y�=����Y��UFV�Y���q��FgV�c3�FGT�����qtD��`1ӛ��+����y������5��Q�++&PU?��I�����`��~���H���q�ZY��DLG6�g��Se������j�
z��t�rS�`Y�һ����z��J�uM�,�G:�"�p����R���R�^�P�d#���kw�]��n�Cl�1��XZ�?�c ,��N�[)k⮍��\jF�w�b�1��X�"|5�_��g (�Xl�)�dc (OjIzؘ��ҩIO�1�=^��23٘��L���3�1���$�c2,)�����a��{�N�%�g?�V�u۽p�6���]K���dZ�T'�c1��w��i5���8��G6ӲS��/�eu�Iz�XLˮ���b���mP���bZ�?��_)�RO�
g|&�iY�&�e!��[��l��R���FZ6�����FZ.��ZX7��6�t��d�|�ּ�F��R��oq�A�m2���#����x�㓙�.���-\
`�|�G����h[��\G$QVVzg�ft-���P�Ra��Z)Itdu�$&�³ +�Rh�Q膠��������Y���0�m�Y��q]��Q��t������o���fEX.�[;Ǌ�fEX�{���w�����"��}Y�7׳"��9��;+���;�S�YԶ@DogER���HrBfER���r6$e1<�Ƈ6�-�Z��φ�\���%�!��Uh�!�l�6ם��٘�|I��٘��so^�gcVv �b
��fV�{�[���Y9���HpJa�O��QK͔Z���H*^�E�O� ���o?�kS:I�S]_��dS4���9M�22��]a���q����8���{%g�,~�g����u�ۙT-��@�,�ԏ��7��d3z򴜲KAp����U޲���gq�^1�4��iq��E�8��i�R�LtBq�ѳ�J�Q�M1�{}KW���ۦ��~(����n�F8(�j�qlw��W$�|K�o�TD�������U)���P5#�������B���M+�C��"+�M��^~dS�K�<��EXW��:��H�n��RD0��oǭ�������%Rւ�@Z~��E�4]��[w;i,�T��U=�(�����7���e0,�|>����~���������w��u0,;���,��aY`K��dX�[ݚ\�S�x��E��XN��(f���zo����lNe��ƛ�	����c����JϺ��՜��w�=��,��w����I%���ԋ����X��?k!,�7��l�ͅ��i�L��\k<��.�嗇���,�u/�5�\H˥��Ws!����vK&�iyK�s#,��&,�7��&͍���i�q���1�1��ds#,�c�N�(j�k�^h�Jde�m`�37�����Y�e��ҭ�YM?�K��*��ɥk� ��pK�T����d�J%S���\)�qYQ��}H0�L�
��}{v��
�ri��sM�
�jo�-��Y��C6��V-����.V�,u?�ܘlՖI5�&]UX�v8E0٪=�v޻�����ryV���X,h�Ug&դA��zs6��̪��^�՘U�&��nK�Z�Q�[	McT�;��{���˹�'l���_��Y��1�z/����&[�Yuw���h^�g?�������aE��J��5ʽ_ѽ��k<cƉ�Vt/~��&=�V�/ަ�v���4ي�E��D�������Զ����,�f�S̲�{��MN�d`E��J�{-CK��eڸ/AX�Okr��ay�VzbGP��t�:��cԖ�`_A�3�n�&[I�-^���:��-��%�:�:a{>�_�AU���7^1���z�\�_�Π�_�@�����#���W�˛Sq���ay�T̹0�R��<�����2,�B�K�%g�X}b��@��6bI{ȥ@ˊ�}5�&[:3�.v��.��YK��0���R���:
I��6�
P��QY�gT��2i�9��֐L��K�������!}�iݻ��p���na��:��m��R��qdk�Lj}7q���&���$�zk��UK�Na�5k&mI⚍���մfOa���q(4;K�˚lE��v�,�$V4/ޞc���eE��*���͋+��T+�W�w��#��y�O�d]����y��<��YW4/���5ɒYѼ�������Ѽ�tR�������Ӓ=�bX�x��t    ����nd$��BZw��d����SE��k#�{Qo�l�����=I2��H˥���k���2�������1IV���&�����dk#��-v2�7����fX'���jm���u��`����f|�.�v;
)M&ۅaYۂ�y}�0-��P�l�]��غ살ړ�K^�.H뽽�b�]�V�p|�k�L��r�$|vAZ.�����?�"��A~�|W�e�^��ЮHˏӊ�[6L�+�riKU�W�.�weZ� �W�+��/��xW�����}W���(�V�]�����b솴|��I��nHK�;��~7��I-}*��]�ݻ�p�!-��~�Iy��;�]wCRⳠƋgM��r�4�vP�?e@<]�MR�7x(),�v__��T[*+��*��li,�K@އ��J��~�[:K=�1x�&ۢ�T�+� �{�U��-���'I�&ۂ��wY�'�Y��JR`wGV�&�wGX�;�w
vGV~Y{r��;�> ��vGV��r��&�Y������wd5��PR��;����e����jzG�lwDu��L�Qͧ�4e_mET.�Z���ɶ"+�Z�!׊�����&ۊ�\Z�b[�|VV�+ފ��b{;H���ˏ��ĉ�2,�Zx綕a5�o�Ҋ�`X��U^Xú�M��5����'��{0,덗\f�ò�z��df�����`V�-<�U܃Yu�񐾖�����dT�UX�э��dT��6)Y�Ѻ��W�w+p���$֊�cDS��\\e~͎��|��֤Վ�ŕvo��;�����}-I���+�V�t4��w1�k�[O���]�']�HyXE��J%�D�a�����^ �w��q���^d����,�i��^J�kS�ʎ��z��Z�j���u�6��5ѺXO�����u����f
�����ˏ�]E�b=��M�;oW�2�%��s��[�w2X�s���g�ȳUt.�[7�T���K��}�L�7���II�፬�"	����_��fħ�R������nƣE\�X(�K��"0מ����Dv�k�C�Ef^���������s���-bko�C�?-r�I�Ɋx��9��<R�[xIZI�R���'��G����3�V�[{J8Z���g��/�h���*\������{wu�"�+N��������G�������\]�N�4��ki���c�ȫ+�ݻ�������$��h���3�Asu�!;��UMG�lg9��������2���&��s���ѮL����Jv7��,%�6h|u%��i�)�#q����fj���Ö��V��z��.yu%�W�e��8ڑiUcn�Օ�w짽{K���v�v�5?ӕhyl/w�<g��籟�Ŗ̣�:O��v�`덵���ʿAX�Ύ%G�E'��{�;�y\��j��IFWW��q��9q���M�/8O����?���T���'�'�: ���UP9���򫭾���������풷����Z>;�������+�C&^o�� �������*k��[6�v�vr�~�}s����'7w-�S_�f�KueE�k{�MU�@p�vLr���"8}_�{y�N���$��M�K/��=R�f�m���Օ���M.�>Z7<��))b�~ܱiKt�H�}�R�hf ��GN3n'R�O3����M?t��-R�^�d�-Rs�
Nh�+3pk�����ϟ�[��U��}b?C��b�2G&>o-{�$m�����u���.��-��	��j�b�ZVa����9 _���{���a5��7����Ҋ��k5������rԼ����=�-`�uB��/�s'i�w�蓟�X��<�8vLWr�y�.��n#6��˖�����ͼ�n#6}���S�Fl�䛔ϙ�l�v�j��6�fm4���ێ����4���fn����G���-���ٌ�^�8h���ܺ�^�%��ܺo���Z\���<?����]0B��Z\��hxB���u��?5>X��N=X�٤F��&8��N����Ѓ�O-�N����Vd�ud}��S+�>����%�V7�$�oZ��Պ����,��*�nq�"7�|V�M�@��mx��Shb��ͷ��6�V��{�X�b�h���?5٘Ն�n�sX�����M�W�;�Ã���ۗ�gҼZ���n�?�y��](�/�!9?=����g_\Ct.>oMx7Fw��xѨ���&������^��,0U��zb��������v��&�n��`��
�S���_���|b�I���?f���c��nb!�'U��zo��4�Uat�3�5<<8�A-[�$kb텵�o/�3vwq�Ė1�]oQ[���ּ���.,�^`��I�ף��D����QZ�������n�}��+J9��9�Z���ځ\���	��^[�db˺�_+i�����c����&�������}y�P�UEt.��ă�":y:��o��UEt�]tj�(��(Η�*�d��ɗ���V�����5tѩ_C �x�N���i 9k{e�=�[��h�v����h���-�����y�v����m<�`����b;��(g�·�_��@�e[�:�xN�y�^'���̟E�A��3��FY%&���G&l�\W'�s�s��Hnz��}���Dt.�KM�O$7�.�ٛ@r��s�F�Dp��ot��F����$#9	��>�
��}��D�hk��*>���>q��뉩W�}r���?�^�����p��h����s)��y�������5(W{+L��3m��WW7�s�.��9Z$מ� ��u�Hε:����"��X$ǯu#9�*\�quu3:�哏?�fr�Ǻ�n���M>I=��2:����\�nDw���$��$�ۏ6t���V��{I�[At��;r��E�7�$�Z�P�s�rM�׏VIk�p��յ��@O��������L�L��Z4Q�sǼ��@�Z0Q�{�MY�R��Z0Qj�{5��\�_��:���|�_��䰿���ճCK�#zԶ[�Ԓd�|�Gk�R������]0R�ͧ�I�#�Ѫ�?Б_>ʣ�;�B��յ`���{ҩ��`�\���&}�����{o������+�>�|uؑ���zr���"��g����F JC?Z����ڣEp�j$��7��iF%9*n��ӧ�2kD��e%+mD�H�4�=Z$���Zr���2�Tw��L=�N��`�T}�}���8혮�Wl��<v��r�VM� �u-(�bk`L[��G�Su@�-(�-��,3����Uҥ�jޫk�@iſbwώ�,�־���ڻ���+���m��KPpO��4j�	���-�'W[�Չ×���m��EpO�[-k�����+�+��`�\��F㢮��Z�9��{;kŽ7:�j�;y���C'��:y�~-{Y���Z�Z���l�:y��M%��v/eT:#m����!�y~�͒�v♶�ج��(���غ��ſ��ٍg��s�c�F"g�!G��ּֽ���c�\�|�	S��f���4�h7i��(IB�YX;��*tA��6+���	m^�l����8_�Mamw;��u����x?�&��A�e�P�T���Ջ9���IZ�:ιEm"���H��m"7�R>Z����������<-R�+e4�/�h���t�-��[�o��յ��X��{otMB�`�\��k�lO\���	�̮k�6y:���E�k	�ɯ�o���`�������`�<Z�0����۟s��IkO4y$��I��?r���"�{mQ��Fh���$�v-�%�(��RK��ڂ]�h�%
�m-�%�v����Y���H���J��'�$�%��kTxғ`�\�o��K�W�h�7P-��v�ޫɨ@�W�h��V�Kal�XflR��{>�Z�&�^�_��&^?Ɉ�27���߲�+�
ܚw�әlݤ6���(l�H�IZ=����h;i��j��*�&����%�$Wk��ن_�K�hݿ����Zo'«����z�*�H$�$��2Z�zcL�>;�+
(��
�"�:ў��N��D���@��� i��k�禓�rk����Z��Z�^��f�zKr�d y�M�vN�:�a�o��t�H�m7ǫ�&�~}oBy0�{k�냹����ߦ    �?&�4{��DbX�n�߻�jioVg��6k�=1���jԞE�����kly� 1��ڝ����fK��ܫ�ֿ�3Ғ�2��W��փ�_�a�>��=.��ֽ���X2k��>	_��dn�vo=��༫�7��-���Z��I"��H{�S����Z�XR�$��v{������5�T�{i�]aTz}���#��{����gkk��αӏh#��ݝ��l�v�����H�-�K�-b���'78ڀm���H����z���%G:R����tc�ᖆ_v̕Jc����F�m��ho���xGNVC�cl�Z��9���_�-L�w�cl�y_��El>"���.P/���"�i���6iK�Dzal��F�X��vv����<R�fY�=����i�W����n�t2zEj�©,������{wE�"4w�φ�ݭ^�k���������X�6YG��<곞^p������H�W�&�h�é��{�0F�!�7��(�7�v'I����ܬ�XM�N}7����������େ��G;����0Y�m#�O8�Zq/7��6i�_�Ξv��m���G�u���x�������'�p�y���8���p�y������\|u=�JyVO���o�W����c��?m��/��;�[ǟ�֋��0����G{{�R����ԧiBώU{8���(�\+~g����z)2��=�~>ڙ���p�y��3Jxk����m^�ǫk8�|�������?����,W���j=x�{8�|�ݳ���2��\gJ߰2�{�Y�U\��5�(�-����vw@I2��*k�76�9]i-��I䠀�y��:�eEi�beˠn�Z�����t��T+�~��iL�%�Zo�nq���qJ^�-�M��)y��s���_��n�9����#>�&�a�c��jg��M����=s��O�� �l�_�wx�3���	*��&CS�F�j�>���F��Z=Zd��퀐��̼��$�F-"󻥲�e��շ'K�Z����֠�Ԫ���׀Ԫ��&��}!��K��b�no-K=鋱��c�^F_�M�2�d\��i�#}1��W�p?��[�c�dZ��
/������u�t�#鋹YJ@v"�7sS�K�
���-���t37��xv�����a�o�ּ�6�����I��4��[�)=u6rs��܁��͍���6��ܼ��$wMT-��f�'Wo-r����_-�ͽ�����Ark�[�y�۴07�Z��xz;�3�0�����s���ian��ԒeHs;{h�� Z��m�ߐV�^��~�V��� D�C+cS/|��E+R�Fj2�:��M�*V�ZhEl�x������{mV�d�ֺX�'�L��Ө���K�������\��Tm�����b�7�ipV-X�WC���Z����6e��3M�op~�j�;�ڐ�-���iCn�)��~r�OW:��U��k��4����I�ޣEn�S�v�*��v��$JUAl��Lg\���ئ-Y���i]����t*�m>%r썪 ���L�{1��-oC���ڑ��6�ٮI;r[��[ �KVGn˫�L+�mybp�~hGl�O�Z��vĶ|��N�#��Id%��-�h��)ю���a�O?�3��&1:�����26s�[�X[��TY���Wa�S���o�8�TEj�y=���h��M�~�Ƅ�m���%~�*R�6l�­m[���dW�h����l.#gI�%���0E�Ĵ^�I{~E����Ԝ]�葘V��� 
-�V��q��0Hk�V�3�I����sڽy�$��&m��G�h������Ľh�x�
� ٩Q�I�)iˌ;E�䞒���m��A��E���6�=�H[J*�$�C�:|ަ�<uv��!G����4�s�'i��ɐD�䦴�y�@��)�Y,�>��S�Yމ�Or�%�����eM�ObZo̐|����3�%3	�$��]2xe�>I{���A�&i���ɝ�U�M�����d�6I{���i�I�[~�|�E��jշ <ԣM�޻��߫���Y�m���$��Z�&�Z[�I���NI //��#������J�l6y��5K��y5O��8
�z�d�p�Y�=6��JZo���0�`�'��9�$m�/�9��Z�m+��V� ��?*P��hK/�;Z��=���*���n�Fb��؉�>*`�[0sh���'U�B�Q��S�d����N,kRBۉQ������h���k��8kT����΢��h�ͪ�lȻ�ѐ��L%19GCl�-�u��-�m���ѐ�r�6;'�-�%��Gl���%��6I+�����h��fw%W�)P��m't�hsHa�W��E4���n���4��*eZa�{#�|*���6�\ht��Zo5�`�ވx��'��p�����%6������۱F�{7k��4�@�F�v�zE�ڈވkk�>����\�z�/,��ڙ��~����{Ǌ�JZ�k��͆Yv28:c�Ag�elw�.p���h%�b�26ˈ+Y���M���d8(b������"���Nm�"7�U��W����+����6�֞��J��"��^�HCG���؁�݇"6�k�;!�@l~a�m¨�~��n0�ށ�|c�mY�ج��'^R��1�Ϩ���_�@l>KZ+�F�w 6yz�*��yŲ�)?��s�4|r�-;��$n� �O�uR�����*xbTjh0�A�)�r����VQ��A��R�G���)k�v?���ٙ�F�G��F�Օ���<G�I<�}:�؄��`�G���-��}D{D?�;�O��>5�=���hk�1q�Gw�-��4P��F$�_EwD�Z�3г�0X����������.�v/0cCi,�����û����)f�����#3N����e|�46b�ϡ`�l�摙�#�o@lmI֩al�V���d8l��Z-p����p�eܬ�������:k�n�h�̷���MJ���'��(vf�I����o���7����y ��f4J�H�W"�nF�d>C�	��ftJ�S�}0�p��)��p�%9��)�OI���y����,�c�;ޯnVFgkaV`1+�Sw�x���Ի���1�u�"����luΊ�nBk���y��Y�:X��o7gr��1]f]�������I���3Ifp��A�ʋg���3ݝd���H{{T���l�Z����:k=�����g�� k6�v��Kb��h��'9�ur�g4K��d%�3�%�)8���ftKֳ|�l;�[�^�ܳ�ݒ��\�u���ݒ�Ϊ5YftKޫy�s���v/�H�NtK��;�&�A��MvKMAl�_;bAl��֒:�ّ���j:�v�&�E��̎��رg�(fGj�;��y��HM<������W���~��ޞ��J������Kq�m����,�[A+OP�,�Z�GW����J�o�L>���\�u���G��GkvTr�0�W�h��1���WR�3����oP֎��`��^���Tf�J�����`��z�.�H)���W�h�:������m����X3x%�m>����`��.�:�R���*Oɏ�����zw�$v	FI}[^��8q��j�;n� ���zo�L�X۽�Cb����A�m����Ty�˞�)��)�Z��d>NI���r��m
k���d�����%��T�v��!YV�`���VI:IjY;��k-1�t�ٯM2��(�$Wk�ǚl�g�I����d�3�$��&���`��J�Gp�s;i���l��MR_�B���\�#�;I��&vpI����v�I��Ւ�I�=�-y����t5`����?m7�N���,����m��aw�no��+�V�ZB@O�9�Flvы}g�̍ؼ�Q�R��Fl~5�	\�߀���9�&� 5}F�X��_ѳ�ob���y�)� 5O��l��
R^8����U���}�H��*Hmx{֤g�6<*���Ć'��� ��T�&�|Eb�1��xUDv��r�VEd�J��j��A�����Ȗo&��eU$����f�*�Q뽇��������H͓����V���\���!�嗘e��jHmy���ԖhYl�R�l�^���VCl�9aJ���������n5���t��������܂��'�=z��[��{|֓ kI! r  �J�[RI�1Y�~-i���$�|��֛�q���NZ��ɷ) �II!� m�~l�.p��d�-Y�U�ő�Alo�3��VGl�cS��:b���qGl��$�����
�N�̑:�~$YG�ܑ����ρΊ��xN�Jr���92�n-k9��72�Y����:���+�#�9��+ٯ�h������|���Z���y=�#��NP������_J���շ��_R�ݝ����"�[6��<����o9ttZ����ֳ&�k ��\�J6����r�`��=�!&Cg �[Y�~��iY����-N�8|�M�$�.�[�yUC�<�b�tƞu�Y�����Ú������tO#��'�NQ�Y��?<&C�P4Y�&C�sNM���ʴ��m1��+׭��,���HcM�V=����ܬ��9��u�BڛV�l�Ve�������l���?�%����,�Y �fS�O��R�6/�H�����$�Κ���-ᶐ��^
i����ݻe���Fn�w�4>����ǲ˽�Fn�������ܖ_�������,�n����5�X]�y��Y43-p�LXg5|�&[�$������f��]~4Q�h��������蒸V�u	�g�]����_��_�?uF8      �   �  x����n�0�g�)� �9��LA�d�R(�y9�'��D:GR�}� C���.�zGɩk�C7ɺ����å��v��K�+�?��{�zC��Z[��H/�X8��A�Q�;b���	G�,���Eh:1����H��s5�<��$�d�ـ��Ao�^b���\$�<�w��A��ZgC$�"�ׁ_����D������;>UM�nAg;�54k8 ͮ��K�����)��z��!Ac��$5-.��^Xb���Yc�������}��uLPGt9o�<���J}B��[׽4��ɾ���gj�Z�!;[#eS"Cq��T��hBh�_�%�-E�y%�k5)ʱ��J���e����nu>�ݹ���W�����`�r��G�M�<Ww5Ƅs��1� �5�*�F<8Ζ���H�{�e�p<��=�q�L�i鬫R�p���`++g�C�s~uA�X����%�'0p0党3��
y�C�<u��'��Ĩa�������{��.���@(.Սw�]%���XP[Y�a� Y,�v��I�X�N��^��px�D�/�k�H�jV��v��֋4���f�.W|N'����y��e_e��[��� 4�Kv���
	99p�ݴ &S5g��4^�\�uo�&��8����^5�����/wҺ�\�mDIp�ʓ�lX�\T�nR�+�-��`�Sܣ�G��k~�>�����g���F�°�"�\�Ũ(��0      �   }   x�=L�
�0<o�b?@<)�1{��L�V�[Ҵ�~�)Z�y,;��6ֻ?�]�qԙ#��s�:��3�2� |GV#�gZ�/tM-z�$��3��'��<dS��8H�$�Ï�1�=�0j      �   3   x�36�4��440�300�4�4�L,NIKL�)�F��@����� �0	�      �   #   x�3�t�+)JLI�4�2�N|d�r��qqq p��      �   O   x�37�420��54�52�4�4�4���/JI�U(���L�,ILIT(H,JTH�IL�/J|�8_!%_!9�(�aAf>W� ��      �      x�37�4��445�300�r�-�b���� 4��      �   #   x�3��M�+M��2�t,-��M,�LN����� q�      �      x�31�4��420��54�54����� *��      �   �   x�}��
�0��_��'��N��&z�Rh�p���d���%_�lrA��x�C�O��U�Z�9ü+��\3װ��o?ifv7��_RŤB��_Tǔ��S��4�D{ +j$6�{Ŏ�u��C���o�F��5IT�������ٴ\p_+�>�^T�      �   �   x�5�ۑ�0C�����y8����XY����D�p)�Eui�'յ�6�t�=4�S�-	������B-�R-��x5�{=�W�!<���C�������˹n�d�F��[-k<d����M����1�;�}(�6R�-މoW�7T7�7��,�W�X��!�0�>;�}�ZC�xp�Fn2�����	�7o      �   �   x�m��
�0E�7�h|,��N�t3��b||���F�L��!�s�Z��M���4r���%z(Q���hȝ��q����+�p���hn��b�F������ǰ�(ب�ᛞ�0^�Q|<���TR��j��n;�}��0�
c"��B�/Y
=�      �      x�3�t�����e�镘W�X����� V�{      �   (   x�344�420��440�300������ʵ������ ��g      �   G   x�e��	�0г�K����a��J҂�<�p8�ZV���TP��J/�q����^����w5�0�O      �   2   x�345�4�444�440�300��$-�Ḿ���PdL!�9\a� H�q      �   6   x�3�tNLI,.)JL��2�t�HM.-��8��s2�3������;F��� ���      �   6   x�3�JM�+�LL��2�tJ̬ ��9�K�R�3N�ļ���D� �^�      �   +   x�3�tLJ-*I�2�JM�ɬJLI�2�tN�KN��c���� ۫
�      �   B   x�3�tLJ-*��2�t�+�LL��2�H,J�L��M�+IUpJ̬ 	�p�X��Ήyɩ9 v� ��	      �   �   x�e��
�0E��~�Pq�ev�"]�y��)�M��m�Ԟչ�2����.�h���0.a�um�P����L�
;i��P��>��j�2�,�pv�[5��p1�S��U����KD��tM��:#�\+S=      �   H   x����0���0�3!I�K���j?�a0Q�M���҂'ڬS����3�t8��A|������/      �   3   x���  ���0��q�9T.�G"��@�ǒ}��Kx��ځ���R�      �   (   x�3�)JL�L���K��2�t�M-JO�K�L����� ��	�      �   -   x�3�J-�LI�K�L��2�t��M-��9�SsJs��b���� B2      �      x��**��4����� ��      �   5   x�3�����O/J�M�L�.sNw���L������L����p��qqq ݥ�      �   l   x�3�41�42�tI-N�+��)KM�/RH�W�,.I�M�,�L���L�KI-�)ͬ�2�4�44����K,�H�SI�SHIUpN,J�J���AtqgxVQI.W� b6+�     